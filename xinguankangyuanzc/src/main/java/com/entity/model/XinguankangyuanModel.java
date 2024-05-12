package com.entity.model;

import com.entity.XinguankangyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 新冠抗原
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinguankangyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 新冠抗原编号
     */
    private String xinguankangyuanUuidNumber;


    /**
     * 新冠抗原名称
     */
    private String xinguankangyuanName;


    /**
     * 新冠抗原照片
     */
    private String xinguankangyuanPhoto;


    /**
     * 新冠抗原类型
     */
    private Integer xinguankangyuanTypes;


    /**
     * 新冠抗原库存
     */
    private Integer xinguankangyuanKucunNumber;


    /**
     * 新冠抗原原价
     */
    private Double xinguankangyuanOldMoney;


    /**
     * 现价/积分
     */
    private Double xinguankangyuanNewMoney;


    /**
     * 新冠抗原热度
     */
    private Integer xinguankangyuanClicknum;


    /**
     * 新冠抗原介绍
     */
    private String xinguankangyuanContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer xinguankangyuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
