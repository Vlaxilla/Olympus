package com.rental.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


@TableName("location_car")
public class LocationCar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Node number
     */
    @TableId(value = "location_id", type = IdType.INPUT)
    private Integer locationId;
    /**
     * The vehicle number
     */
    private Integer cid;


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "LocationCar{" +
                "locationId=" + locationId +
                ", cid=" + cid +
                "}";
    }
}
