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
 * 防护知识
 *
 * @author 
 * @email
 */
@TableName("fanghuzhishi")
public class FanghuzhishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FanghuzhishiEntity() {

	}

	public FanghuzhishiEntity(T t) {
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
     * 知识标题
     */
    @ColumnInfo(comment="知识标题",type="varchar(200)")
    @TableField(value = "fanghuzhishi_name")

    private String fanghuzhishiName;


    /**
     * 知识类型
     */
    @ColumnInfo(comment="知识类型",type="int(11)")
    @TableField(value = "fanghuzhishi_types")

    private Integer fanghuzhishiTypes;


    /**
     * 知识图片
     */
    @ColumnInfo(comment="知识图片",type="varchar(200)")
    @TableField(value = "fanghuzhishi_photo")

    private String fanghuzhishiPhoto;


    /**
     * 视频
     */
    @ColumnInfo(comment="视频",type="varchar(200)")
    @TableField(value = "fanghuzhishi_video")

    private String fanghuzhishiVideo;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 点击量
     */
    @ColumnInfo(comment="点击量",type="int(11)")
    @TableField(value = "fanghuzhishi_clicknum")

    private Integer fanghuzhishiClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 知识详情
     */
    @ColumnInfo(comment="知识详情",type="longtext")
    @TableField(value = "fanghuzhishi_content")

    private String fanghuzhishiContent;


    /**
     * 创建时间
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
	 * 获取：知识标题
	 */
    public String getFanghuzhishiName() {
        return fanghuzhishiName;
    }
    /**
	 * 设置：知识标题
	 */

    public void setFanghuzhishiName(String fanghuzhishiName) {
        this.fanghuzhishiName = fanghuzhishiName;
    }
    /**
	 * 获取：知识类型
	 */
    public Integer getFanghuzhishiTypes() {
        return fanghuzhishiTypes;
    }
    /**
	 * 设置：知识类型
	 */

    public void setFanghuzhishiTypes(Integer fanghuzhishiTypes) {
        this.fanghuzhishiTypes = fanghuzhishiTypes;
    }
    /**
	 * 获取：知识图片
	 */
    public String getFanghuzhishiPhoto() {
        return fanghuzhishiPhoto;
    }
    /**
	 * 设置：知识图片
	 */

    public void setFanghuzhishiPhoto(String fanghuzhishiPhoto) {
        this.fanghuzhishiPhoto = fanghuzhishiPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getFanghuzhishiVideo() {
        return fanghuzhishiVideo;
    }
    /**
	 * 设置：视频
	 */

    public void setFanghuzhishiVideo(String fanghuzhishiVideo) {
        this.fanghuzhishiVideo = fanghuzhishiVideo;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：点击量
	 */
    public Integer getFanghuzhishiClicknum() {
        return fanghuzhishiClicknum;
    }
    /**
	 * 设置：点击量
	 */

    public void setFanghuzhishiClicknum(Integer fanghuzhishiClicknum) {
        this.fanghuzhishiClicknum = fanghuzhishiClicknum;
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
	 * 获取：知识详情
	 */
    public String getFanghuzhishiContent() {
        return fanghuzhishiContent;
    }
    /**
	 * 设置：知识详情
	 */

    public void setFanghuzhishiContent(String fanghuzhishiContent) {
        this.fanghuzhishiContent = fanghuzhishiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fanghuzhishi{" +
            ", id=" + id +
            ", fanghuzhishiName=" + fanghuzhishiName +
            ", fanghuzhishiTypes=" + fanghuzhishiTypes +
            ", fanghuzhishiPhoto=" + fanghuzhishiPhoto +
            ", fanghuzhishiVideo=" + fanghuzhishiVideo +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", fanghuzhishiClicknum=" + fanghuzhishiClicknum +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", fanghuzhishiContent=" + fanghuzhishiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
