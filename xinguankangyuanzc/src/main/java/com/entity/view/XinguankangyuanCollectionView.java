package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinguankangyuanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 新冠抗原收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinguankangyuan_collection")
public class XinguankangyuanCollectionView extends XinguankangyuanCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String xinguankangyuanCollectionValue;

	//级联表 新冠抗原
		/**
		* 新冠抗原编号
		*/

		@ColumnInfo(comment="新冠抗原编号",type="varchar(200)")
		private String xinguankangyuanUuidNumber;
		/**
		* 新冠抗原名称
		*/

		@ColumnInfo(comment="新冠抗原名称",type="varchar(200)")
		private String xinguankangyuanName;
		/**
		* 新冠抗原照片
		*/

		@ColumnInfo(comment="新冠抗原照片",type="varchar(200)")
		private String xinguankangyuanPhoto;
		/**
		* 新冠抗原类型
		*/
		@ColumnInfo(comment="新冠抗原类型",type="int(11)")
		private Integer xinguankangyuanTypes;
			/**
			* 新冠抗原类型的值
			*/
			@ColumnInfo(comment="新冠抗原类型的字典表值",type="varchar(200)")
			private String xinguankangyuanValue;
		/**
		* 新冠抗原库存
		*/

		@ColumnInfo(comment="新冠抗原库存",type="int(11)")
		private Integer xinguankangyuanKucunNumber;
		/**
		* 新冠抗原原价
		*/
		@ColumnInfo(comment="新冠抗原原价",type="decimal(10,2)")
		private Double xinguankangyuanOldMoney;
		/**
		* 现价/积分
		*/
		@ColumnInfo(comment="现价/积分",type="decimal(10,2)")
		private Double xinguankangyuanNewMoney;
		/**
		* 新冠抗原热度
		*/

		@ColumnInfo(comment="新冠抗原热度",type="int(11)")
		private Integer xinguankangyuanClicknum;
		/**
		* 新冠抗原介绍
		*/

		@ColumnInfo(comment="新冠抗原介绍",type="longtext")
		private String xinguankangyuanContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xinguankangyuanDelete;
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



	public XinguankangyuanCollectionView() {

	}

	public XinguankangyuanCollectionView(XinguankangyuanCollectionEntity xinguankangyuanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, xinguankangyuanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getXinguankangyuanCollectionValue() {
		return xinguankangyuanCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setXinguankangyuanCollectionValue(String xinguankangyuanCollectionValue) {
		this.xinguankangyuanCollectionValue = xinguankangyuanCollectionValue;
	}


	//级联表的get和set 新冠抗原

		/**
		* 获取： 新冠抗原编号
		*/
		public String getXinguankangyuanUuidNumber() {
			return xinguankangyuanUuidNumber;
		}
		/**
		* 设置： 新冠抗原编号
		*/
		public void setXinguankangyuanUuidNumber(String xinguankangyuanUuidNumber) {
			this.xinguankangyuanUuidNumber = xinguankangyuanUuidNumber;
		}

		/**
		* 获取： 新冠抗原名称
		*/
		public String getXinguankangyuanName() {
			return xinguankangyuanName;
		}
		/**
		* 设置： 新冠抗原名称
		*/
		public void setXinguankangyuanName(String xinguankangyuanName) {
			this.xinguankangyuanName = xinguankangyuanName;
		}

		/**
		* 获取： 新冠抗原照片
		*/
		public String getXinguankangyuanPhoto() {
			return xinguankangyuanPhoto;
		}
		/**
		* 设置： 新冠抗原照片
		*/
		public void setXinguankangyuanPhoto(String xinguankangyuanPhoto) {
			this.xinguankangyuanPhoto = xinguankangyuanPhoto;
		}
		/**
		* 获取： 新冠抗原类型
		*/
		public Integer getXinguankangyuanTypes() {
			return xinguankangyuanTypes;
		}
		/**
		* 设置： 新冠抗原类型
		*/
		public void setXinguankangyuanTypes(Integer xinguankangyuanTypes) {
			this.xinguankangyuanTypes = xinguankangyuanTypes;
		}


			/**
			* 获取： 新冠抗原类型的值
			*/
			public String getXinguankangyuanValue() {
				return xinguankangyuanValue;
			}
			/**
			* 设置： 新冠抗原类型的值
			*/
			public void setXinguankangyuanValue(String xinguankangyuanValue) {
				this.xinguankangyuanValue = xinguankangyuanValue;
			}

		/**
		* 获取： 新冠抗原库存
		*/
		public Integer getXinguankangyuanKucunNumber() {
			return xinguankangyuanKucunNumber;
		}
		/**
		* 设置： 新冠抗原库存
		*/
		public void setXinguankangyuanKucunNumber(Integer xinguankangyuanKucunNumber) {
			this.xinguankangyuanKucunNumber = xinguankangyuanKucunNumber;
		}

		/**
		* 获取： 新冠抗原原价
		*/
		public Double getXinguankangyuanOldMoney() {
			return xinguankangyuanOldMoney;
		}
		/**
		* 设置： 新冠抗原原价
		*/
		public void setXinguankangyuanOldMoney(Double xinguankangyuanOldMoney) {
			this.xinguankangyuanOldMoney = xinguankangyuanOldMoney;
		}

		/**
		* 获取： 现价/积分
		*/
		public Double getXinguankangyuanNewMoney() {
			return xinguankangyuanNewMoney;
		}
		/**
		* 设置： 现价/积分
		*/
		public void setXinguankangyuanNewMoney(Double xinguankangyuanNewMoney) {
			this.xinguankangyuanNewMoney = xinguankangyuanNewMoney;
		}

		/**
		* 获取： 新冠抗原热度
		*/
		public Integer getXinguankangyuanClicknum() {
			return xinguankangyuanClicknum;
		}
		/**
		* 设置： 新冠抗原热度
		*/
		public void setXinguankangyuanClicknum(Integer xinguankangyuanClicknum) {
			this.xinguankangyuanClicknum = xinguankangyuanClicknum;
		}

		/**
		* 获取： 新冠抗原介绍
		*/
		public String getXinguankangyuanContent() {
			return xinguankangyuanContent;
		}
		/**
		* 设置： 新冠抗原介绍
		*/
		public void setXinguankangyuanContent(String xinguankangyuanContent) {
			this.xinguankangyuanContent = xinguankangyuanContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXinguankangyuanDelete() {
			return xinguankangyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXinguankangyuanDelete(Integer xinguankangyuanDelete) {
			this.xinguankangyuanDelete = xinguankangyuanDelete;
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
		return "XinguankangyuanCollectionView{" +
			", xinguankangyuanCollectionValue=" + xinguankangyuanCollectionValue +
			", xinguankangyuanUuidNumber=" + xinguankangyuanUuidNumber +
			", xinguankangyuanName=" + xinguankangyuanName +
			", xinguankangyuanPhoto=" + xinguankangyuanPhoto +
			", xinguankangyuanKucunNumber=" + xinguankangyuanKucunNumber +
			", xinguankangyuanOldMoney=" + xinguankangyuanOldMoney +
			", xinguankangyuanNewMoney=" + xinguankangyuanNewMoney +
			", xinguankangyuanClicknum=" + xinguankangyuanClicknum +
			", xinguankangyuanContent=" + xinguankangyuanContent +
			", xinguankangyuanDelete=" + xinguankangyuanDelete +
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