package com.lemo.manage.user;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.lemo.manage.utility.StringTool;

@TableBind(tableName="sys_userfavor",pkName="FavorID")
public class UserFavor extends Model<UserFavor>{
	private static final long serialVersionUID = 1L;
	public final static UserFavor dao = new UserFavor();
	
}
