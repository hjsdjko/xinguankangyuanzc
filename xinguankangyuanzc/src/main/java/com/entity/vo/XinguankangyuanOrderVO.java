package com.entity.vo;

import com.entity.XinguankangyuanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 新冠抗原订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinguankangyuan_order")
public class XinguankangyuanOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "xinguankangyuan_order_uuid_number")
    private String xinguankangyuanOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 新冠抗原
     */

    @TableField(value = "xinguankangyuan_id")
    private Integer xinguankangyuanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "xinguankangyuan_order_true_price")
    private Double xinguankangyuanOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "xinguankangyuan_order_types")
    private Integer xinguankangyuanOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "xinguankangyuan_order_payment_types")
    private Integer xinguankangyuanOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：订单编号
	 */
    public String getXinguankangyuanOrderUuidNumber() {
        return xinguankangyuanOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setXinguankangyuanOrderUuidNumber(String xinguankangyuanOrderUuidNumber) {
        this.xinguankangyuanOrderUuidNumber = xinguankangyuanOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：新冠抗原
	 */
    public Integer getXinguankangyuanId() {
        return xinguankangyuanId;
    }


    /**
	 * 获取：新冠抗原
	 */

    public void setXinguankangyuanId(Integer xinguankangyuanId) {
        this.xinguankangyuanId = xinguankangyuanId;
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
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getXinguankangyuanOrderTruePrice() {
        return xinguankangyuanOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setXinguankangyuanOrderTruePrice(Double xinguankangyuanOrderTruePrice) {
        this.xinguankangyuanOrderTruePrice = xinguankangyuanOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getXinguankangyuanOrderTypes() {
        return xinguankangyuanOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setXinguankangyuanOrderTypes(Integer xinguankangyuanOrderTypes) {
        this.xinguankangyuanOrderTypes = xinguankangyuanOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getXinguankangyuanOrderPaymentTypes() {
        return xinguankangyuanOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setXinguankangyuanOrderPaymentTypes(Integer xinguankangyuanOrderPaymentTypes) {
        this.xinguankangyuanOrderPaymentTypes = xinguankangyuanOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
