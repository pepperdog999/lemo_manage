package com.lemo.manage.mall;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="mall_baseinfo",pkName="MallID")
public class MallInfo extends Model<MallInfo>{
	private static final long serialVersionUID = 1L;
	public final static MallInfo dao = new MallInfo();

}
