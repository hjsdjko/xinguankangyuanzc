package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FanghuzhishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 防护知识
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fanghuzhishi")
public class FanghuzhishiView extends FanghuzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 知识类型的值
	*/
	@ColumnInfo(comment="知识类型的字典表值",type="varchar(200)")
	private String fanghuzhishiValue;




	public FanghuzhishiView() {

	}

	public FanghuzhishiView(FanghuzhishiEntity fanghuzhishiEntity) {
		try {
			BeanUtils.copyProperties(this, fanghuzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 知识类型的值
	*/
	public String getFanghuzhishiValue() {
		return fanghuzhishiValue;
	}
	/**
	* 设置： 知识类型的值
	*/
	public void setFanghuzhishiValue(String fanghuzhishiValue) {
		this.fanghuzhishiValue = fanghuzhishiValue;
	}




	@Override
	public String toString() {
		return "FanghuzhishiView{" +
			", fanghuzhishiValue=" + fanghuzhishiValue +
			"} " + super.toString();
	}
}
