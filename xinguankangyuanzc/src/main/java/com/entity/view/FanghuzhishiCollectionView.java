package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FanghuzhishiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 防护知识收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fanghuzhishi_collection")
public class FanghuzhishiCollectionView extends FanghuzhishiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String fanghuzhishiCollectionValue;

	//级联表 防护知识
		/**
		* 知识标题
		*/

		@ColumnInfo(comment="知识标题",type="varchar(200)")
		private String fanghuzhishiName;
		/**
		* 知识类型
		*/
		@ColumnInfo(comment="知识类型",type="int(11)")
		private Integer fanghuzhishiTypes;
			/**
			* 知识类型的值
			*/
			@ColumnInfo(comment="知识类型的字典表值",type="varchar(200)")
			private String fanghuzhishiValue;
		/**
		* 知识图片
		*/

		@ColumnInfo(comment="知识图片",type="varchar(200)")
		private String fanghuzhishiPhoto;
		/**
		* 视频
		*/

		@ColumnInfo(comment="视频",type="varchar(200)")
		private String fanghuzhishiVideo;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 点击量
		*/

		@ColumnInfo(comment="点击量",type="int(11)")
		private Integer fanghuzhishiClicknum;
		/**
		* 知识详情
		*/

		@ColumnInfo(comment="知识详情",type="longtext")
		private String fanghuzhishiContent;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public FanghuzhishiCollectionView() {

	}

	public FanghuzhishiCollectionView(FanghuzhishiCollectionEntity fanghuzhishiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fanghuzhishiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getFanghuzhishiCollectionValue() {
		return fanghuzhishiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setFanghuzhishiCollectionValue(String fanghuzhishiCollectionValue) {
		this.fanghuzhishiCollectionValue = fanghuzhishiCollectionValue;
	}


	//级联表的get和set 防护知识

		/**
		* 获取： 知识标题
		*/
		public String getFanghuzhishiName() {
			return fanghuzhishiName;
		}
		/**
		* 设置： 知识标题
		*/
		public void setFanghuzhishiName(String fanghuzhishiName) {
			this.fanghuzhishiName = fanghuzhishiName;
		}
		/**
		* 获取： 知识类型
		*/
		public Integer getFanghuzhishiTypes() {
			return fanghuzhishiTypes;
		}
		/**
		* 设置： 知识类型
		*/
		public void setFanghuzhishiTypes(Integer fanghuzhishiTypes) {
			this.fanghuzhishiTypes = fanghuzhishiTypes;
		}


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

		/**
		* 获取： 知识图片
		*/
		public String getFanghuzhishiPhoto() {
			return fanghuzhishiPhoto;
		}
		/**
		* 设置： 知识图片
		*/
		public void setFanghuzhishiPhoto(String fanghuzhishiPhoto) {
			this.fanghuzhishiPhoto = fanghuzhishiPhoto;
		}

		/**
		* 获取： 视频
		*/
		public String getFanghuzhishiVideo() {
			return fanghuzhishiVideo;
		}
		/**
		* 设置： 视频
		*/
		public void setFanghuzhishiVideo(String fanghuzhishiVideo) {
			this.fanghuzhishiVideo = fanghuzhishiVideo;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 点击量
		*/
		public Integer getFanghuzhishiClicknum() {
			return fanghuzhishiClicknum;
		}
		/**
		* 设置： 点击量
		*/
		public void setFanghuzhishiClicknum(Integer fanghuzhishiClicknum) {
			this.fanghuzhishiClicknum = fanghuzhishiClicknum;
		}

		/**
		* 获取： 知识详情
		*/
		public String getFanghuzhishiContent() {
			return fanghuzhishiContent;
		}
		/**
		* 设置： 知识详情
		*/
		public void setFanghuzhishiContent(String fanghuzhishiContent) {
			this.fanghuzhishiContent = fanghuzhishiContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "FanghuzhishiCollectionView{" +
			", fanghuzhishiCollectionValue=" + fanghuzhishiCollectionValue +
			", fanghuzhishiName=" + fanghuzhishiName +
			", fanghuzhishiPhoto=" + fanghuzhishiPhoto +
			", fanghuzhishiVideo=" + fanghuzhishiVideo +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", fanghuzhishiClicknum=" + fanghuzhishiClicknum +
			", fanghuzhishiContent=" + fanghuzhishiContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
