package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.Car;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarForm extends BaseInfoForm {

    /**
     * The vehicle number
     */
    private Integer cid;
    /**
     * The vehicle maker
     */
    private String maker;
    /**
     * The vehicle model
     */
    private String model;
    /**
     *  Model:Samll,Medium,large and luxurious
     */
    private String type;
    /**
     *  production time
     */
    private Date productTime;
    private String productTimeStr;
    /**
     * Rent/day
     */
    private BigDecimal rent;
    /**
     * Car pictures
     */
    private String cicon;
    /**
     * Information insertion time
     */
    private Date createTime;
    /**
     *Information modification time
     */
    private Date updateTime;
    /**
     *Whether to disable, 1:disable; 0;available
     */
    private Integer disable;
    /**
     * Vehicle status.0:no outlets added; 1:added to the network ; 2:in use(has been added to the network);?
     */
    private Integer status;

    private MultipartFile iconFile;
    public Car toCar(Car entity) {
        if (this.cid != null) {
            entity.setCid(this.cid);
        }
        if (this.maker != null) {
            entity.setMaker(this.maker);
        }
        if (this.model != null) {
            entity.setModel(this.model);
        }
        if (this.type != null) {
            entity.setType(this.type);
        }
        if (this.productTime != null) {
            entity.setProductTime(this.productTime);
        }
        if (this.productTimeStr != null) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                entity.setProductTime(date.parse(this.productTimeStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (this.rent != null) {
            entity.setRent(this.rent);
        }
        if (this.cicon != null) {
            entity.setCicon(this.cicon);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.updateTime != null) {
            entity.setUpdateTime(this.updateTime);
        }
        if (this.disable != null) {
            entity.setDisable(this.disable);
        }
        if (this.status != null) {
            entity.setStatus(this.status);
        }
        return entity;
    }


    public Wrapper<Car> toWrapper() {
        Wrapper<Car> wrapper = new EntityWrapper<>();
        if (this.cid != null) {
            wrapper.eq("cid", this.cid);
        }
        if (this.maker != null) {
            wrapper.like("maker", this.maker);
        }
        if (this.model != null) {
            wrapper.like("model", this.model);
        }
        if (this.type != null) {
            wrapper.like("type", this.type);
        }
        if (this.productTime != null) {
            wrapper.eq("product_time", this.productTime);
        }
        if (this.rent != null) {
            wrapper.eq("rent", this.rent);
        }
        if (this.cicon != null) {
            wrapper.like("cicon", this.cicon);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.updateTime != null) {
            wrapper.eq("update_time", this.updateTime);
        }
        if (this.disable != null) {
            wrapper.eq("disable", this.disable);
        }
        if (this.status != null) {
            wrapper.eq("status", this.status);
        }
        return wrapper;
    }

    public MultipartFile getIconFile() {
        return iconFile;
    }

    public String getProductTimeStr() {
        return productTimeStr;
    }

    public void setProductTimeStr(String productTimeStr) {
        this.productTimeStr = productTimeStr;
    }

    public void setIconFile(MultipartFile iconFile) {
        this.iconFile = iconFile;
    }

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
