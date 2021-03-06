package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.Location;

import java.util.Date;

public class LocationForm extends BaseInfoForm {

    /**
     *Node number
     */
    private Integer locationId;
    /**
     * Node latiitude and longitude
     */
    private String latlng;
    /**
     * Network name
     */
    private String locationName;
    /**
     *Creation time
     */
    private Date createTime;
    /**
     * Modify the time
     */
    private Date updateTime;

    private Integer cid;
    public Location toLocation(Location entity) {
        if (this.locationId != null) {
            entity.setLocationId(this.locationId);
        }
        if (this.latlng != null) {
            entity.setLatlng(this.latlng);
        }
        if (this.locationName != null) {
            entity.setLocationName(this.locationName);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.updateTime != null) {
            entity.setUpdateTime(this.updateTime);
        }
        return entity;
    }


    public Wrapper<Location> toWrapper() {
        Wrapper<Location> wrapper = new EntityWrapper<>();
        if (this.locationId != null) {
            wrapper.eq("location_id", this.locationId);
        }
        if (this.latlng != null) {
            wrapper.like("latlng", this.latlng);
        }
        if (this.locationName != null) {
            wrapper.like("location_name", this.locationName);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.updateTime != null) {
            wrapper.eq("update_time", this.updateTime);
        }
        return wrapper;
    }


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLatlng() {
        return latlng;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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




