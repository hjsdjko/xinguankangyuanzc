package com.entity.vo;

import com.entity.XinguankangyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 新冠抗原
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinguankangyuan")
public class XinguankangyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 新冠抗原编号
     */

    @TableField(value = "xinguankangyuan_uuid_number")
    private String xinguankangyuanUuidNumber;


    /**
     * 新冠抗原名称
     */

    @TableField(value = "xinguankangyuan_name")
    private String xinguankangyuanName;


    /**
     * 新冠抗原照片
     */

    @TableField(value = "xinguankangyuan_photo")
    private String xinguankangyuanPhoto;


    /**
     * 新冠抗原类型
     */

    @TableField(value = "xinguankangyuan_types")
    private Integer xinguankangyuanTypes;


    /**
     * 新冠抗原库存
     */

    @TableField(value = "xinguankangyuan_kucun_number")
    private Integer xinguankangyuanKucunNumber;


    /**
     * 新冠抗原原价
     */

    @TableField(value = "xinguankangyuan_old_money")
    private Double xinguankangyuanOldMoney;


    /**
     * 现价/积分
     */

    @TableField(value = "xinguankangyuan_new_money")
    private Double xinguankangyuanNewMoney;


    /**
     * 新冠抗原热度
     */

    @TableField(value = "xinguankangyuan_clicknum")
    private Integer xinguankangyuanClicknum;


    /**
     * 新冠抗原介绍
     */

    @TableField(value = "xinguankangyuan_content")
    private String xinguankangyuanContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "xinguankangyuan_delete")
    private Integer xinguankangyuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：新冠抗原编号
	 */
    public String getXinguankangyuanUuidNumber() {
        return xinguankangyuanUuidNumber;
    }


    /**
	 * 获取：新冠抗原编号
	 */

    public void setXinguankangyuanUuidNumber(String xinguankangyuanUuidNumber) {
        this.xinguankangyuanUuidNumber = xinguankangyuanUuidNumber;
    }
    /**
	 * 设置：新冠抗原名称
	 */
    public String getXinguankangyuanName() {
        return xinguankangyuanName;
    }


    /**
	 * 获取：新冠抗原名称
	 */

    public void setXinguankangyuanName(String xinguankangyuanName) {
        this.xinguankangyuanName = xinguankangyuanName;
    }
    /**
	 * 设置：新冠抗原照片
	 */
    public String getXinguankangyuanPhoto() {
        return xinguankangyuanPhoto;
    }


    /**
	 * 获取：新冠抗原照片
	 */

    public void setXinguankangyuanPhoto(String xinguankangyuanPhoto) {
        this.xinguankangyuanPhoto = xinguankangyuanPhoto;
    }
    /**
	 * 设置：新冠抗原类型
	 */
    public Integer getXinguankangyuanTypes() {
        return xinguankangyuanTypes;
    }


    /**
	 * 获取：新冠抗原类型
	 */

    public void setXinguankangyuanTypes(Integer xinguankangyuanTypes) {
        this.xinguankangyuanTypes = xinguankangyuanTypes;
    }
    /**
	 * 设置：新冠抗原库存
	 */
    public Integer getXinguankangyuanKucunNumber() {
        return xinguankangyuanKucunNumber;
    }


    /**
	 * 获取：新冠抗原库存
	 */

    public void setXinguankangyuanKucunNumber(Integer xinguankangyuanKucunNumber) {
        this.xinguankangyuanKucunNumber = xinguankangyuanKucunNumber;
    }
    /**
	 * 设置：新冠抗原原价
	 */
    public Double getXinguankangyuanOldMoney() {
        return xinguankangyuanOldMoney;
    }


    /**
	 * 获取：新冠抗原原价
	 */

    public void setXinguankangyuanOldMoney(Double xinguankangyuanOldMoney) {
        this.xinguankangyuanOldMoney = xinguankangyuanOldMoney;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getXinguankangyuanNewMoney() {
        return xinguankangyuanNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setXinguankangyuanNewMoney(Double xinguankangyuanNewMoney) {
        this.xinguankangyuanNewMoney = xinguankangyuanNewMoney;
    }
    /**
	 * 设置：新冠抗原热度
	 */
    public Integer getXinguankangyuanClicknum() {
        return xinguankangyuanClicknum;
    }


    /**
	 * 获取：新冠抗原热度
	 */

    public void setXinguankangyuanClicknum(Integer xinguankangyuanClicknum) {
        this.xinguankangyuanClicknum = xinguankangyuanClicknum;
    }
    /**
	 * 设置：新冠抗原介绍
	 */
    public String getXinguankangyuanContent() {
        return xinguankangyuanContent;
    }


    /**
	 * 获取：新冠抗原介绍
	 */

    public void setXinguankangyuanContent(String xinguankangyuanContent) {
        this.xinguankangyuanContent = xinguankangyuanContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXinguankangyuanDelete() {
        return xinguankangyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXinguankangyuanDelete(Integer xinguankangyuanDelete) {
        this.xinguankangyuanDelete = xinguankangyuanDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
