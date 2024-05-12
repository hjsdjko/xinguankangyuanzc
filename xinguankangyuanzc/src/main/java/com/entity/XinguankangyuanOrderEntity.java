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
 * 新冠抗原订单
 *
 * @author 
 * @email
 */
@TableName("xinguankangyuan_order")
public class XinguankangyuanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinguankangyuanOrderEntity() {

	}

	public XinguankangyuanOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "xinguankangyuan_order_uuid_number")

    private String xinguankangyuanOrderUuidNumber;


    /**
     * 收货地址
     */
    @ColumnInfo(comment="收货地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 新冠抗原
     */
    @ColumnInfo(comment="新冠抗原",type="int(11)")
    @TableField(value = "xinguankangyuan_id")

    private Integer xinguankangyuanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "xinguankangyuan_order_true_price")

    private Double xinguankangyuanOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "xinguankangyuan_order_types")

    private Integer xinguankangyuanOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "xinguankangyuan_order_payment_types")

    private Integer xinguankangyuanOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：订单编号
	 */
    public String getXinguankangyuanOrderUuidNumber() {
        return xinguankangyuanOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setXinguankangyuanOrderUuidNumber(String xinguankangyuanOrderUuidNumber) {
        this.xinguankangyuanOrderUuidNumber = xinguankangyuanOrderUuidNumber;
    }
    /**
	 * 获取：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 设置：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：新冠抗原
	 */
    public Integer getXinguankangyuanId() {
        return xinguankangyuanId;
    }
    /**
	 * 设置：新冠抗原
	 */

    public void setXinguankangyuanId(Integer xinguankangyuanId) {
        this.xinguankangyuanId = xinguankangyuanId;
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
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getXinguankangyuanOrderTruePrice() {
        return xinguankangyuanOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setXinguankangyuanOrderTruePrice(Double xinguankangyuanOrderTruePrice) {
        this.xinguankangyuanOrderTruePrice = xinguankangyuanOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getXinguankangyuanOrderTypes() {
        return xinguankangyuanOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setXinguankangyuanOrderTypes(Integer xinguankangyuanOrderTypes) {
        this.xinguankangyuanOrderTypes = xinguankangyuanOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getXinguankangyuanOrderPaymentTypes() {
        return xinguankangyuanOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setXinguankangyuanOrderPaymentTypes(Integer xinguankangyuanOrderPaymentTypes) {
        this.xinguankangyuanOrderPaymentTypes = xinguankangyuanOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "XinguankangyuanOrder{" +
            ", id=" + id +
            ", xinguankangyuanOrderUuidNumber=" + xinguankangyuanOrderUuidNumber +
            ", addressId=" + addressId +
            ", xinguankangyuanId=" + xinguankangyuanId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", xinguankangyuanOrderTruePrice=" + xinguankangyuanOrderTruePrice +
            ", xinguankangyuanOrderTypes=" + xinguankangyuanOrderTypes +
            ", xinguankangyuanOrderPaymentTypes=" + xinguankangyuanOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
