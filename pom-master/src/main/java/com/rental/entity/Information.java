package com.rental.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;


public class Information implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * The title��
     */
    private String title;
    /**
     * Content abstract
     */
    private String summary;
    /**
     * Charger
     */
    private String charger;
    /**
     * Contant phone number
     */
    private String mobile;
    /**
     * Province
     */
    private String province;
    /**
     * City/jurisdiction
     */
    private String city;
    /**
     * District
     */
    private String district;
    /**
     * Address��
     */
    private String address;
    /**
     * Longitude
     */
    private String longitude;
    /**
     * Latitude
     */
    private String latitude;
    @TableField("create_date")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @TableField("update_date")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @TableField("create_user")
    private Integer createUser;
    @TableField("update_user")
    private Integer updateUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "Information{" +
        "id=" + id +
        ", title=" + title +
        ", summary=" + summary +
        ", charger=" + charger +
        ", mobile=" + mobile +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", address=" + address +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", createUser=" + createUser +
        ", updateUser=" + updateUser +
        "}";
    }
}
