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
 * 检测记录
 *
 * @author 
 * @email
 */
@TableName("jiance")
public class JianceEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianceEntity() {

	}

	public JianceEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "jiance_name")

    private String jianceName;


    /**
     * 检测图片
     */
    @ColumnInfo(comment="检测图片",type="varchar(200)")
    @TableField(value = "jiance_photo")

    private String jiancePhoto;


    /**
     * 检测结果
     */
    @ColumnInfo(comment="检测结果",type="int(11)")
    @TableField(value = "jiance_types")

    private Integer jianceTypes;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="检测时间",type="timestamp")
    @TableField(value = "jiance_time")

    private Date jianceTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "jiance_text")

    private String jianceText;


    /**
     * 创建时间  listShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：标题
	 */
    public String getJianceName() {
        return jianceName;
    }
    /**
	 * 设置：标题
	 */

    public void setJianceName(String jianceName) {
        this.jianceName = jianceName;
    }
    /**
	 * 获取：检测图片
	 */
    public String getJiancePhoto() {
        return jiancePhoto;
    }
    /**
	 * 设置：检测图片
	 */

    public void setJiancePhoto(String jiancePhoto) {
        this.jiancePhoto = jiancePhoto;
    }
    /**
	 * 获取：检测结果
	 */
    public Integer getJianceTypes() {
        return jianceTypes;
    }
    /**
	 * 设置：检测结果
	 */

    public void setJianceTypes(Integer jianceTypes) {
        this.jianceTypes = jianceTypes;
    }
    /**
	 * 获取：检测时间
	 */
    public Date getJianceTime() {
        return jianceTime;
    }
    /**
	 * 设置：检测时间
	 */

    public void setJianceTime(Date jianceTime) {
        this.jianceTime = jianceTime;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：备注
	 */
    public String getJianceText() {
        return jianceText;
    }
    /**
	 * 设置：备注
	 */

    public void setJianceText(String jianceText) {
        this.jianceText = jianceText;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiance{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jianceName=" + jianceName +
            ", jiancePhoto=" + jiancePhoto +
            ", jianceTypes=" + jianceTypes +
            ", jianceTime=" + DateUtil.convertString(jianceTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", jianceText=" + jianceText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
