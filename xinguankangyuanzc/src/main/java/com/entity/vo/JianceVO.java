package com.entity.vo;

import com.entity.JianceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 检测记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiance")
public class JianceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 标题
     */

    @TableField(value = "jiance_name")
    private String jianceName;


    /**
     * 检测图片
     */

    @TableField(value = "jiance_photo")
    private String jiancePhoto;


    /**
     * 检测结果
     */

    @TableField(value = "jiance_types")
    private Integer jianceTypes;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiance_time")
    private Date jianceTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 备注
     */

    @TableField(value = "jiance_text")
    private String jianceText;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：标题
	 */
    public String getJianceName() {
        return jianceName;
    }


    /**
	 * 获取：标题
	 */

    public void setJianceName(String jianceName) {
        this.jianceName = jianceName;
    }
    /**
	 * 设置：检测图片
	 */
    public String getJiancePhoto() {
        return jiancePhoto;
    }


    /**
	 * 获取：检测图片
	 */

    public void setJiancePhoto(String jiancePhoto) {
        this.jiancePhoto = jiancePhoto;
    }
    /**
	 * 设置：检测结果
	 */
    public Integer getJianceTypes() {
        return jianceTypes;
    }


    /**
	 * 获取：检测结果
	 */

    public void setJianceTypes(Integer jianceTypes) {
        this.jianceTypes = jianceTypes;
    }
    /**
	 * 设置：检测时间
	 */
    public Date getJianceTime() {
        return jianceTime;
    }


    /**
	 * 获取：检测时间
	 */

    public void setJianceTime(Date jianceTime) {
        this.jianceTime = jianceTime;
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
	 * 设置：备注
	 */
    public String getJianceText() {
        return jianceText;
    }


    /**
	 * 获取：备注
	 */

    public void setJianceText(String jianceText) {
        this.jianceText = jianceText;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
