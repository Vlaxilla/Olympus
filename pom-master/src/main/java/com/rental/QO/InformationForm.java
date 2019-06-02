package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.Information;
import java.util.Date;

public class InformationForm extends BaseInfoForm {

    private Integer id;
    /**
     * The title
     */
    private String title;
    /**
     * Content abstract?
     */
    private String summary;
    /**
     * Charger?
     */
    private String charger;
    /**
     * Contant phone number
     */
    private String mobile;
    /**
     *Province
     */
    private String province;
    /**
     *City/jurisdiction?
     */
    private String city;
    /**
     * District
     */
    private String district;
    /**
     * Address¢˜
     */
    private String address;
    /**
     *Longitude
     */
    private String longitude;
    /**
     * Latitude
     */
    private String latitude;
    private Date createDate;
    private Date updateDate;
    private Integer createUser;
    private Integer updateUser;


    public Information toInformation(Information entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.title != null) {
            entity.setTitle(this.title);
        }
        if (this.summary != null) {
            entity.setSummary(this.summary);
        }
        if (this.charger != null) {
            entity.setCharger(this.charger);
        }
        if (this.mobile != null) {
            entity.setMobile(this.mobile);
        }
        if (this.province != null) {
            entity.setProvince(this.province);
        }
        if (this.city != null) {
            entity.setCity(this.city);
        }
        if (this.district != null) {
            entity.setDistrict(this.district);
        }
        if (this.address != null) {
            entity.setAddress(this.address);
        }
        if (this.longitude != null) {
            entity.setLongitude(this.longitude);
        }
        if (this.latitude != null) {
            entity.setLatitude(this.latitude);
        }
        if (this.createDate != null) {
            entity.setCreateDate(this.createDate);
        }
        if (this.updateDate != null) {
            entity.setUpdateDate(this.updateDate);
        }
        if (this.createUser != null) {
            entity.setCreateUser(this.createUser);
        }
        if (this.updateUser != null) {
            entity.setUpdateUser(this.updateUser);
        }
        return entity;
    }


    public Wrapper<Information> toWrapper() {
        Wrapper<Information> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.title != null) {
            wrapper.like("title", this.title);
        }
        if (this.summary != null) {
            wrapper.like("summary", this.summary);
        }
        if (this.charger != null) {
            wrapper.like("charger", this.charger);
        }
        if (this.mobile != null) {
            wrapper.like("mobile", this.mobile);
        }
        if (this.province != null) {
            wrapper.like("province", this.province);
        }
        if (this.city != null) {
            wrapper.like("city", this.city);
        }
        if (this.district != null) {
            wrapper.like("district", this.district);
        }
        if (this.address != null) {
            wrapper.like("address", this.address);
        }
        if (this.longitude != null) {
            wrapper.like("longitude", this.longitude);
        }
        if (this.latitude != null) {
            wrapper.like("latitude", this.latitude);
        }
        if (this.createDate != null) {
            wrapper.eq("create_date", this.createDate);
        }
        if (this.updateDate != null) {
            wrapper.eq("update_date", this.updateDate);
        }
        if (this.createUser != null) {
            wrapper.eq("create_user", this.createUser);
        }
        if (this.updateUser != null) {
            wrapper.eq("update_user", this.updateUser);
        }
        return wrapper;
    }


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
