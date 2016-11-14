package com.office.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.office.common.controller.BaseController;
import com.office.common.exception.BusinessException;
import com.office.dto.ActiveUser;
import com.office.entity.TPermission;
import com.office.entity.TRole;
import com.office.entity.TUser;
import com.office.service.IPermissionService;
import com.office.service.IRoleService;
import com.office.service.IUserService;
import com.office.util.PasswordHelper;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("login")
	@ResponseBody
	private Map<String, Object> login(TUser user,HttpSession session){
		Map<String, Object> result=new HashMap<String, Object>();
		String msg="";
		boolean success=false;
		try {
			TUser currentUser=userService.findByUserName(user);
			if(currentUser!=null){
				user.setSalt(currentUser.getSalt());
				PasswordHelper.EncryptionPassword(user);
				if(currentUser.getPassword().equals(user.getPassword())){
					if(currentUser.getLocked()){
						List<TPermission> permissions=permissionService.findPermissionByUser(currentUser);
						if(null!=permissions&&permissions.size()!=0){
							List<TRole> roles=roleService.findRolesByUser(currentUser);
							ActiveUser activeUser=new ActiveUser();
							activeUser.setIdUser(currentUser.getIdUser());
							activeUser.setUsername(currentUser.getUsername());
							activeUser.setPermissions(permissions);
							activeUser.setRoles(roles);
							session.setAttribute("currentUser", activeUser);
							success=true;
						}else{
							msg="用户没有权限！";
						}
					}else{
						msg="用户账号已锁定！";
					}
				}else{
					msg="用户名或密码错误！";
				}
			}else{
				msg="用户不存在！";
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		result.put("msg", msg);
		result.put("success", success);
		return successJson(result);
	}
	
	@RequestMapping("toIndex")
	public ModelAndView toIndex(){
		return success("index");
	}
	
	@RequestMapping("toLoginUI")
	private ModelAndView toLoginUI(){
		return success("loginUI");
	}
	
	
	// 用户退出
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) throws Exception {
		// session失效
		session.invalidate();
		// 重定向到商品查询页面
		return success("loginUI");
	}

	@Override
	protected String getForwardPrefix() {
		return "user";
	}

}
