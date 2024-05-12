package com.entity.vo;

import com.entity.FanghuzhishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 防护知识
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fanghuzhishi")
public class FanghuzhishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 知识标题
     */

    @TableField(value = "fanghuzhishi_name")
    private String fanghuzhishiName;


    /**
     * 知识类型
     */

    @TableField(value = "fanghuzhishi_types")
    private Integer fanghuzhishiTypes;


    /**
     * 知识图片
     */

    @TableField(value = "fanghuzhishi_photo")
    private String fanghuzhishiPhoto;


    /**
     * 视频
     */

    @TableField(value = "fanghuzhishi_video")
    private String fanghuzhishiVideo;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 点击量
     */

    @TableField(value = "fanghuzhishi_clicknum")
    private Integer fanghuzhishiClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 知识详情
     */

    @TableField(value = "fanghuzhishi_content")
    private String fanghuzhishiContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：知识标题
	 */
    public String getFanghuzhishiName() {
        return fanghuzhishiName;
    }


    /**
	 * 获取：知识标题
	 */

    public void setFanghuzhishiName(String fanghuzhishiName) {
        this.fanghuzhishiName = fanghuzhishiName;
    }
    /**
	 * 设置：知识类型
	 */
    public Integer getFanghuzhishiTypes() {
        return fanghuzhishiTypes;
    }


    /**
	 * 获取：知识类型
	 */

    public void setFanghuzhishiTypes(Integer fanghuzhishiTypes) {
        this.fanghuzhishiTypes = fanghuzhishiTypes;
    }
    /**
	 * 设置：知识图片
	 */
    public String getFanghuzhishiPhoto() {
        return fanghuzhishiPhoto;
    }


    /**
	 * 获取：知识图片
	 */

    public void setFanghuzhishiPhoto(String fanghuzhishiPhoto) {
        this.fanghuzhishiPhoto = fanghuzhishiPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getFanghuzhishiVideo() {
        return fanghuzhishiVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setFanghuzhishiVideo(String fanghuzhishiVideo) {
        this.fanghuzhishiVideo = fanghuzhishiVideo;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：点击量
	 */
    public Integer getFanghuzhishiClicknum() {
        return fanghuzhishiClicknum;
    }


    /**
	 * 获取：点击量
	 */

    public void setFanghuzhishiClicknum(Integer fanghuzhishiClicknum) {
        this.fanghuzhishiClicknum = fanghuzhishiClicknum;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：知识详情
	 */
    public String getFanghuzhishiContent() {
        return fanghuzhishiContent;
    }


    /**
	 * 获取：知识详情
	 */

    public void setFanghuzhishiContent(String fanghuzhishiContent) {
        this.fanghuzhishiContent = fanghuzhishiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
