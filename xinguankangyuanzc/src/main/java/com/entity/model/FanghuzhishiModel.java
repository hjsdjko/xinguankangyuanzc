package com.entity.model;

import com.entity.FanghuzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 防护知识
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FanghuzhishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 知识标题
     */
    private String fanghuzhishiName;


    /**
     * 知识类型
     */
    private Integer fanghuzhishiTypes;


    /**
     * 知识图片
     */
    private String fanghuzhishiPhoto;


    /**
     * 视频
     */
    private String fanghuzhishiVideo;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 点击量
     */
    private Integer fanghuzhishiClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 知识详情
     */
    private String fanghuzhishiContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
