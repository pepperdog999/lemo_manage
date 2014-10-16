package com.lemo.manage.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lemo.manage.utility.DateUtils;
import com.lemo.manage.utility.PropertiesFactoryHelper;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.Restful;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.ext.plugin.sqlinxml.SqlKit;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;

/**
 * @类名字：CommonController
 * @类描述：
 * @author:Carl.Wu
 * @版本信息：
 * @日期：2013-11-14
 * @Copyright 足下 Corporation 2013 
 * @版权所有
 *
 */
@ControllerBind(controllerKey = "/")
// @Before({ Restful.class, SessionInViewInterceptor.class })
public class LoginController extends BaseController {

	public void index() {
		render("/login.html");
	}
	
	public void banner(){
		render("banner.html");
	}
	
	public void nvaTree(){
		render("navTree.html");
	}
	
	/**
	 * @方法名:login
	 * @方法描述：用户登录
	 * @author: mula.liu
	 * @return: void
	 * @version: 2013-11-14 下午2:47:38
	 * @throws UnsupportedEncodingException 
	 */
	public void login() throws UnsupportedEncodingException {
		String userName = getPara("userName");
		String userPass = getPara("userPass");
		String corpID = getPara("corpID");
		String validateCode = getPara("validateCode"); //验证码，暂时不用。
		Map<String,Object> data = new HashMap<String, Object>();
		if (userName != null && userPass != null && !userName.isEmpty() && !userPass.isEmpty()) {
			Record user = Db.findFirst(SqlKit.sql("user.login"), new Object[] {
					userName, userPass });
			if (user != null && user.getInt("RoleID") < 3 ) {
				String cookiev = new StringBuilder(user.getStr("UserID")).append("&")
						.append(user.getStr("LoginName")).append("&")
						.append(URLEncoder.encode(user.getStr("Caption"),"UTF-8")).append("&")
						.append(user.getInt("RoleID")).append("&")
						.append(corpID).append("&").toString();
				this.setCookie("lemo_managecookie", cookiev, 86400000);
				//把登录用户信息写入日志表及在线的ehCache
				data.put("Result", true);
				data.put("Msg", "用户验证成功！");
			}else {
				data.put("Result", false);
				data.put("Msg", "用户名或密码错误！");
			}

		}else{
			data.put("Result", false);
			data.put("Msg", "登录信息不完整！");
		}
		renderJson(data);
	}
	
	public void logout() {
		this.removeCookie("lemo_managecookie");
		redirect("/login.html");
	}

}
