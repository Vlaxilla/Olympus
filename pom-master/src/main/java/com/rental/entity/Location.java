package com.rental.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;


public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Node number
     */
    @TableId(value = "location_id", type = IdType.AUTO)
    private Integer locationId;
    /**
     * Node latitude and longitude?
     */
    private String latlng;
    /**
     * Network name
     */
    @TableField("location_name")
    private String locationName;
    /**
     *creation time
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * Modify the time
     */
    @TableField("update_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
        return "Location{" +
        "locationId=" + locationId +
        ", latlng=" + latlng +
        ", locationName=" + locationName +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
