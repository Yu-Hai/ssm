package com.office.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.office.common.controller.BaseController;
import com.office.dto.GameDTO;
import com.office.game.Calculator;
import com.office.game.Game24Point;
import com.office.util.RandomUtil;
import com.office.util.StringUtil;

@Controller
@RequestMapping("/game")
public class GameController extends BaseController{
	
	@RequestMapping("/index.do")
	public ModelAndView toPlay24PointGame(){
		return success("index");
	}
	
	@RequestMapping("/general24PointGame.do")
	@ResponseBody
	public Map<String, Object> general24PointGame(){
		GameDTO game=new GameDTO();
		
		game.setStartDate(System.currentTimeMillis());;
		int[] randomArray = RandomUtil.generalArrayleRandom(1, 13, 4);
		List<String> answerList = Game24Point.easyCount(randomArray);//存储答案的集合
		int answerCount=answerList.size();
		while (answerCount < 1) {// 若游戏的解法小于0是，重新生成
			randomArray = RandomUtil.generalArrayleRandom(1, 13, 4);
			answerList = Game24Point.easyCount(randomArray);
			answerCount=answerList.size();
		}
		game.setNum(RandomUtil.generalArrayleRandom(1, 4, 4));//生成四种花色
		game.setEndDate(System.currentTimeMillis());
		game.setNumber(randomArray);
		game.setAnswerList(answerList);
		game.setAnswerCount(answerCount);
		return successJson(game);
	}
	
	@RequestMapping("/check24PointGameResult")
	@ResponseBody
	public Map<String, Object> check24PointGameResult(GameDTO game){
		Map<String, Object> result=new HashMap<String, Object>();
		boolean success=false;
		String msg="";
		boolean isContain=true;
		List<Integer> numberList=StringUtil.getNumFromStr(game.getSolution());
		List<Integer> numList=game.getNumberList();
		for (Integer integer : numberList) {
			if(!numList.contains(integer)){
				isContain=false;
				break;
			}
		}
		if(isContain){
			BigDecimal bd=Calculator.calc(game.getSolution());
			int bdInt=bd.intValue();
			
			if(bdInt==24){
				msg="恭喜你，回答正确！";
				success=true;
			}else{
				msg="很遗憾，回答错误！";
			}
		}else{
			msg="答案与题目不符！";
		}
		result.put("msg", msg);
		result.put("success", success);
		return successJson(result);
	}
	
	@RequestMapping("/find24PointAnswer")
	@ResponseBody
	public Map<String, Object> find24PointAnswer(GameDTO game){
		Map<String, Object> result=new HashMap<String, Object>();
		List<String> answerList=Game24Point.easyCount(game.getNumberArray());
		result.put("answerList", answerList);
		return successJson(result);
	}
	
	

	@Override
	protected String getForwardPrefix() {
		return "game";
	}

}
