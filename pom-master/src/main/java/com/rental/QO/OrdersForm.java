package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.Orders;

import java.math.BigDecimal;
import java.util.Date;




public class OrdersForm extends BaseInfoForm {

    /**
     * Order number
     */
    private Integer orderId;
    /**
     * Order amount¢ù
     */
    private BigDecimal orderAmount;
    /**
     * Customer number
     */
    private Integer userId;
    /**
     * Customer name 
     */
    private String userName;
    /**
     * The customer phone
     */
    private String userPhone;
    /**
     * The customer address
     */
    private String userAddress;
    /**
     * The vehicle number 
     */
    private Integer carId;
    /**
     * The vehicle maker
     */
    private String carMaker;
    /**
     * The vehicle type
     */
    private String carType;
    /**
     * Pick-up address
     */
    private String pickupLocation;
    /**
     * Pick-up time
     */
    private Date pickupTime;
    private String pickupTimeStr;
    /**
     * Return address
     */
    private String dropoffLocation;
    /**
     *Scheduled return time
     */
    private Date dropoffTime;
    private String dropoffTimeStr;
    /**
     * Order status. 0:get in the car; 1:in use; 2:the car has been returned, the order is finished; 3: cancel the order?
     */
    private Integer orderStatus;
    /**
     * Order creation time
     */
    private Date createTime;
    /**
     * Order modification time
     */
    private Date updateTime;


    public Orders toOrders(Orders entity) {
        if (this.orderId != null) {
            entity.setOrderId(this.orderId);
        }
        if (this.orderAmount != null) {
            entity.setOrderAmount(this.orderAmount);
        }
        if (this.userId != null) {
            entity.setUserId(this.userId);
        }
        if (this.userName != null) {
            entity.setUserName(this.userName);
        }
        if (this.userPhone != null) {
            entity.setUserPhone(this.userPhone);
        }
        if (this.userAddress != null) {
            entity.setUserAddress(this.userAddress);
        }
        if (this.carId != null) {
            entity.setCarId(this.carId);
        }
        if (this.carMaker != null) {
            entity.setCarMaker(this.carMaker);
        }
        if (this.carType != null) {
            entity.setCarType(this.carType);
        }
        if (this.pickupLocation != null) {
            entity.setPickupLocation(this.pickupLocation);
        }
        if (this.pickupTime != null) {
            entity.setPickupTime(this.pickupTime);
        }
        if (this.dropoffLocation != null) {
            entity.setDropoffLocation(this.dropoffLocation);
        }
        if (this.dropoffTime != null) {
            entity.setDropoffTime(this.dropoffTime);
        }
        if (this.orderStatus != null) {
            entity.setOrderStatus(this.orderStatus);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.updateTime != null) {
            entity.setUpdateTime(this.updateTime);
        }
        return entity;
    }


    public Wrapper<Orders> toWrapper() {
        Wrapper<Orders> wrapper = new EntityWrapper<>();
        if (this.orderId != null) {
            wrapper.eq("order_id", this.orderId);
        }
        if (this.orderAmount != null) {
            wrapper.eq("order_amount", this.orderAmount);
        }
        if (this.userId != null) {
            wrapper.eq("user_id", this.userId);
        }
        if (this.userName != null) {
            wrapper.like("user_name", this.userName);
        }
        if (this.userPhone != null) {
            wrapper.like("user_phone", this.userPhone);
        }
        if (this.userAddress != null) {
            wrapper.like("user_address", this.userAddress);
        }
        if (this.carId != null) {
            wrapper.eq("car_id", this.carId);
        }
        if (this.carMaker != null) {
            wrapper.like("car_maker", this.carMaker);
        }
        if (this.carType != null) {
            wrapper.like("car_type", this.carType);
        }
        if (this.pickupLocation != null) {
            wrapper.like("pickup_location", this.pickupLocation);
        }
        if (this.pickupTime != null) {
            wrapper.eq("pickup_time", this.pickupTime);
        }
        if (this.dropoffLocation != null) {
            wrapper.like("dropoff_location", this.dropoffLocation);
        }
        if (this.dropoffTime != null) {
            wrapper.eq("dropoff_time", this.dropoffTime);
        }
        if (this.orderStatus != null) {
            wrapper.eq("order_status", this.orderStatus);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.updateTime != null) {
            wrapper.eq("update_time", this.updateTime);
        }
        return wrapper;
    }


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

    public String getPickupTimeStr() {
        return pickupTimeStr;
    }

    public void setPickupTimeStr(String pickupTimeStr) {
        this.pickupTimeStr = pickupTimeStr;
    }

    public String getDropoffTimeStr() {
        return dropoffTimeStr;
    }

    public void setDropoffTimeStr(String dropoffTimeStr) {
        this.dropoffTimeStr = dropoffTimeStr;
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



