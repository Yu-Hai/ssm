package com.office.game;
/**
 * YuHai
 * 
 * 2016.07.21
 * 
 * version 1.0
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.office.dto.GameDTO;
import com.office.util.RandomUtil;

public class Game24Point {
	private List<String> answerList = new ArrayList<String>();

	public List<String> getAnswerList() {
		return answerList;
	}

	public static class Data {
		public float[] arr;
		public String expStr = "";
		public String[] strs;

		public Data() {
		}

		public Data(int a, int b, int c, int d) {
			arr = new float[] { a, b, c, d };
			strs = new String[] { a + "", b + "", c + "", d + "" };
			expStr = a + "";
		}

		public Data(int arr[]) {
			this.arr = new float[] { arr[0], arr[1], arr[2], arr[3] };
			this.strs = new String[] { arr[0] + "", arr[1] + "", arr[2] + "",
					arr[3] + "" };
		}
	}

	public void count(Data data) {
		float[] arr = data.arr;
		if (arr.length <= 1) {
			if (arr.length == 1 && arr[0] == 24) {
				answerList.add(data.expStr.substring(1,
						data.expStr.length() - 1));
			}
			return;
		}
		for (int i = 0, len = arr.length; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				float x = arr[i];
				float y = arr[j];
				String xs = data.strs[i];
				String ys = data.strs[j];
				for (int k = 0; k < 6; k++) {
					Data newData = getNewArr(data, i);
					switch (k) {
					case 0:
						newData.arr[j - 1] = x + y;
						newData.expStr = xs + "+" + ys;
						break;
					case 1:
						newData.arr[j - 1] = x - y;
						newData.expStr = xs + "-" + ys;
						break;
					case 2:
						newData.arr[j - 1] = y - x;
						newData.expStr = ys + "-" + xs;
						break;
					case 3:
						newData.arr[j - 1] = x * y;
						newData.expStr = xs + "*" + ys;
						break;
					case 4:
						if (y != 0) {
							newData.arr[j - 1] = x / y;
							newData.expStr = xs + "/" + ys;
						} else {
							continue;
						}
						break;
					case 5:
						if (x != 0) {
							newData.arr[j - 1] = y / x;
							newData.expStr = ys + "/" + xs;
						} else {
							continue;
						}
						break;
					}
					newData.expStr = "(" + newData.expStr + ")";
					newData.strs[j - 1] = newData.expStr;
					count(newData);
				}
			}
		}

	}

	private static Data getNewArr(Data data, int i) {
		Data newData = new Data();
		newData.expStr = data.expStr;
		newData.arr = new float[data.arr.length - 1];
		newData.strs = new String[data.arr.length - 1];
		for (int m = 0, len = data.arr.length, n = 0; m < len; m++) {
			if (m != i) {
				newData.arr[n] = data.arr[m];
				newData.strs[n] = data.strs[m];
				n++;
			}
		}
		return newData;
	}

	public static final List<String> easyCount(int[] curRandNums) {
		Game24Point count24 = new Game24Point();
		count24.count(new Data(curRandNums));
		Set<String> set = new HashSet<String>(count24.getAnswerList());// ШЅжи
		return new ArrayList<String>(set);
	}

	public static GameDTO showInfo(long start, List<String> answerStris,int[] randomArray) {
		GameDTO game=new GameDTO();
		
		System.out.println("============生成题目成功==========");
		System.out.print("生成内容耗时：");
		System.out.println(System.currentTimeMillis() - start);
		System.out.print("数字(共有" + answerStris.size() + "种解法)：");
		for (int i = 0; i < randomArray.length; i++) {
			System.out.print(randomArray[i] + "      ");
		}
		System.out.println();
		System.out.println("将以上数字加减乘除(+,-,*,/)得出24，并列出算式即可。如发送：(4-2)*12/1");
		
		return game;
	}

	public static void play24PointGame(){
		long start = System.currentTimeMillis();
		int[] randomArray = RandomUtil.generalArrayleRandom(1, 13, 4);
		List<String> answerStris = easyCount(randomArray);//存储答案的集合
		while (answerStris.size() < 1) {// 若游戏的解法小于0是，重新生成
			randomArray = RandomUtil.generalArrayleRandom(1, 13, 4);
			answerStris = easyCount(randomArray);
		}
		showInfo(start, answerStris,randomArray);
//		for (String string : answerStris) {
//			System.out.println(string);
//		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入：");
		String solution=sc.next();
		BigDecimal bd=Calculator.calc(solution);
		int bdInt=bd.intValue();
		if(bdInt==24){
			System.out.println("回答正确！");
		}else{
			System.out.println("回答错误！");
		}
	}
	
	public static void find24PointGameAnswer(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("==========找答案就交给我了==========");
		int[] inputArray =new int[4];
		for (int i = 0; i < 4; i++) {
			System.out.print("第"+(i+1)+"个数字：");
			inputArray[i]=sc.nextInt();
		}
		long start = System.currentTimeMillis();
		List<String> answerStris = easyCount(inputArray);
		System.out.println("数字(共有" + answerStris.size() + "种解法)：");
		int count=1;
		for (String string : answerStris) {
			System.out.println(count+":"+string);
			count++;
		}
		System.out.print("生成内容耗时：");
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void main(String[] args) throws InterruptedException {
		play24PointGame();
		find24PointGameAnswer();
	}
}
