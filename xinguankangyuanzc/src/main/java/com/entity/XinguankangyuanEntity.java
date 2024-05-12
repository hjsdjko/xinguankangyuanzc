package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 新冠抗原
 *
 * @author 
 * @email
 */
@TableName("xinguankangyuan")
public class XinguankangyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinguankangyuanEntity() {

	}

	public XinguankangyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 新冠抗原编号
     */
    @ColumnInfo(comment="新冠抗原编号",type="varchar(200)")
    @TableField(value = "xinguankangyuan_uuid_number")

    private String xinguankangyuanUuidNumber;


    /**
     * 新冠抗原名称
     */
    @ColumnInfo(comment="新冠抗原名称",type="varchar(200)")
    @TableField(value = "xinguankangyuan_name")

    private String xinguankangyuanName;


    /**
     * 新冠抗原照片
     */
    @ColumnInfo(comment="新冠抗原照片",type="varchar(200)")
    @TableField(value = "xinguankangyuan_photo")

    private String xinguankangyuanPhoto;


    /**
     * 新冠抗原类型
     */
    @ColumnInfo(comment="新冠抗原类型",type="int(11)")
    @TableField(value = "xinguankangyuan_types")

    private Integer xinguankangyuanTypes;


    /**
     * 新冠抗原库存
     */
    @ColumnInfo(comment="新冠抗原库存",type="int(11)")
    @TableField(value = "xinguankangyuan_kucun_number")

    private Integer xinguankangyuanKucunNumber;


    /**
     * 新冠抗原原价
     */
    @ColumnInfo(comment="新冠抗原原价",type="decimal(10,2)")
    @TableField(value = "xinguankangyuan_old_money")

    private Double xinguankangyuanOldMoney;


    /**
     * 现价/积分
     */
    @ColumnInfo(comment="现价/积分",type="decimal(10,2)")
    @TableField(value = "xinguankangyuan_new_money")

    private Double xinguankangyuanNewMoney;


    /**
     * 新冠抗原热度
     */
    @ColumnInfo(comment="新冠抗原热度",type="int(11)")
    @TableField(value = "xinguankangyuan_clicknum")

    private Integer xinguankangyuanClicknum;


    /**
     * 新冠抗原介绍
     */
    @ColumnInfo(comment="新冠抗原介绍",type="longtext")
    @TableField(value = "xinguankangyuan_content")

    private String xinguankangyuanContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xinguankangyuan_delete")

    private Integer xinguankangyuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：新冠抗原编号
	 */
    public String getXinguankangyuanUuidNumber() {
        return xinguankangyuanUuidNumber;
    }
    /**
	 * 设置：新冠抗原编号
	 */

    public void setXinguankangyuanUuidNumber(String xinguankangyuanUuidNumber) {
        this.xinguankangyuanUuidNumber = xinguankangyuanUuidNumber;
    }
    /**
	 * 获取：新冠抗原名称
	 */
    public String getXinguankangyuanName() {
        return xinguankangyuanName;
    }
    /**
	 * 设置：新冠抗原名称
	 */

    public void setXinguankangyuanName(String xinguankangyuanName) {
        this.xinguankangyuanName = xinguankangyuanName;
    }
    /**
	 * 获取：新冠抗原照片
	 */
    public String getXinguankangyuanPhoto() {
        return xinguankangyuanPhoto;
    }
    /**
	 * 设置：新冠抗原照片
	 */

    public void setXinguankangyuanPhoto(String xinguankangyuanPhoto) {
        this.xinguankangyuanPhoto = xinguankangyuanPhoto;
    }
    /**
	 * 获取：新冠抗原类型
	 */
    public Integer getXinguankangyuanTypes() {
        return xinguankangyuanTypes;
    }
    /**
	 * 设置：新冠抗原类型
	 */

    public void setXinguankangyuanTypes(Integer xinguankangyuanTypes) {
        this.xinguankangyuanTypes = xinguankangyuanTypes;
    }
    /**
	 * 获取：新冠抗原库存
	 */
    public Integer getXinguankangyuanKucunNumber() {
        return xinguankangyuanKucunNumber;
    }
    /**
	 * 设置：新冠抗原库存
	 */

    public void setXinguankangyuanKucunNumber(Integer xinguankangyuanKucunNumber) {
        this.xinguankangyuanKucunNumber = xinguankangyuanKucunNumber;
    }
    /**
	 * 获取：新冠抗原原价
	 */
    public Double getXinguankangyuanOldMoney() {
        return xinguankangyuanOldMoney;
    }
    /**
	 * 设置：新冠抗原原价
	 */

    public void setXinguankangyuanOldMoney(Double xinguankangyuanOldMoney) {
        this.xinguankangyuanOldMoney = xinguankangyuanOldMoney;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getXinguankangyuanNewMoney() {
        return xinguankangyuanNewMoney;
    }
    /**
	 * 设置：现价/积分
	 */

    public void setXinguankangyuanNewMoney(Double xinguankangyuanNewMoney) {
        this.xinguankangyuanNewMoney = xinguankangyuanNewMoney;
    }
    /**
	 * 获取：新冠抗原热度
	 */
    public Integer getXinguankangyuanClicknum() {
        return xinguankangyuanClicknum;
    }
    /**
	 * 设置：新冠抗原热度
	 */

    public void setXinguankangyuanClicknum(Integer xinguankangyuanClicknum) {
        this.xinguankangyuanClicknum = xinguankangyuanClicknum;
    }
    /**
	 * 获取：新冠抗原介绍
	 */
    public String getXinguankangyuanContent() {
        return xinguankangyuanContent;
    }
    /**
	 * 设置：新冠抗原介绍
	 */

    public void setXinguankangyuanContent(String xinguankangyuanContent) {
        this.xinguankangyuanContent = xinguankangyuanContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinguankangyuanDelete() {
        return xinguankangyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXinguankangyuanDelete(Integer xinguankangyuanDelete) {
        this.xinguankangyuanDelete = xinguankangyuanDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinguankangyuan{" +
            ", id=" + id +
            ", xinguankangyuanUuidNumber=" + xinguankangyuanUuidNumber +
            ", xinguankangyuanName=" + xinguankangyuanName +
            ", xinguankangyuanPhoto=" + xinguankangyuanPhoto +
            ", xinguankangyuanTypes=" + xinguankangyuanTypes +
            ", xinguankangyuanKucunNumber=" + xinguankangyuanKucunNumber +
            ", xinguankangyuanOldMoney=" + xinguankangyuanOldMoney +
            ", xinguankangyuanNewMoney=" + xinguankangyuanNewMoney +
            ", xinguankangyuanClicknum=" + xinguankangyuanClicknum +
            ", xinguankangyuanContent=" + xinguankangyuanContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xinguankangyuanDelete=" + xinguankangyuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
