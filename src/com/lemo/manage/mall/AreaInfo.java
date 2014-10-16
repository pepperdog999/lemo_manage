package com.lemo.manage.mall;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="mall_areainfo",pkName="AreaID")
public class AreaInfo extends Model<AreaInfo>{
	private static final long serialVersionUID = 1L;
	public final static AreaInfo dao = new AreaInfo();

}
