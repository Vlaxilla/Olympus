package com.rental.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int ORDER_PICKING_UP = 0;
    public static final int ORDER_USING = 1;
    public static final int ORDER_FINISHED = 2;
    public static final int ORDER_CANCEL = 3;
    /**
     * Order number
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;
    /**
     * The order amout
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;
    /**
     * Customer number
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * The customer name 
     */
    @TableField("user_name")
    private String userName;
    /**
     * The customer phone
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * The customer address
     */
    @TableField("user_address")
    private String userAddress;
    /**
     * The vehicle number
     */
    @TableField("car_id")
    private Integer carId;
    /**
     *The vrhicle maker
     */
    @TableField("car_maker")
    private String carMaker;
    /**
     * The vehicle type
     */
    @TableField("car_type")
    private String carType;
    /**
     *Pick-up address 
     */
    @TableField("pickup_location")
    private String pickupLocation;
    /**
     *Pick-up time 
     */
    @TableField("pickup_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date pickupTime;
    /**
     * Return address
     */
    @TableField("dropoff_location")
    private String dropoffLocation;
    /**
     *Scheduled return time
     */
    @TableField("dropoff_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date dropoffTime;
    /**
     * Order status. 0:get in the car; 1:in use; 2:the car has been returned, the order is finished; 3: cancel the order
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * Order creation time
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * Order modification time
     */
    @TableField("update_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Date getDropoffTime() {
        return dropoffTime;
    }

    public void setDropoffTime(Date dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                ", userId=" + userId +
                ", userName=" + userName +
                ", userPhone=" + userPhone +
                ", userAddress=" + userAddress +
                ", carId=" + carId +
                ", carMaker=" + carMaker +
                ", carType=" + carType +
                ", pickupLocation=" + pickupLocation +
                ", pickupTime=" + pickupTime +
                ", dropoffLocation=" + dropoffLocation +
                ", dropoffTime=" + dropoffTime +
                ", orderStatus=" + orderStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
