package com.rental.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;



public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int NEW_CAR = 0;
    public static final int RECORD = 1;
    public static final int BEING_USING = 2;
    /**
     * The vehicle number
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    /**
     * The vehicle maker
     */
    private String maker;
    /**
     *The vehicle model
     */
    private String model;
    /**
     * Model:Samll,Medium,large and luxurious
     */
    private String type;
    /**
     * production time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("product_time")
    private Date productTime;
    /**
     *Rent/day
     */
    private BigDecimal rent;
    /**
     *Car pictures
     */
    private String cicon;
    /**
     *Information insertion time
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * Information modification time
     */
    @TableField("update_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * Whether to disable, 1:disable; 0;available.
     */
    private Integer disable;
    /**
     * Vehicle status.0:no outlets added; 1:added to the network ; 2:in use(has been added to the network);
     */
    private Integer status;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getCicon() {
        return cicon;
    }

    public void setCicon(String cicon) {
        this.cicon = cicon;
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

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", maker=" + maker +
                ", model=" + model +
                ", type=" + type +
                ", productTime=" + productTime +
                ", rent=" + rent +
                ", cicon=" + cicon +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", disable=" + disable +
                ", status=" + status +
                "}";
    }
}
