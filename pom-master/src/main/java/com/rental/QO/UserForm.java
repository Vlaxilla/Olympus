package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.User;

import java.util.Date;

public class UserForm extends BaseInfoForm {

    /**
     * Serial number
     */
    private Integer id;
    /**
     * The user id
     */
    private String idCard;
    /**
     *  Username
     */
    private String username;
    /**
     *Password
     */
    private String password;
    /**
     *  Phone
     */
    private String phone;
    /**
     *  Residential address
     */
    private String address;
    /**
     *Credit score
     */
    private Integer credit;
    /**
     *Mask indentification, 0;normal, 1:blocked?
     */
    private Integer isBlacklist;
    /**
     * Account creation time
     */
    private Date createTime;
    /**
     * Last landing time?
     */
    private Date lastLoginTime;
    /**
     * The avatar
     */
    private String icon;
    /**
     * 1:ordinary user, 2:administrator?
     */
    private Integer type;


    public User toUser(User entity) {
        if (this.id != null) {
            entity.setId(this.id);
        }
        if (this.idCard != null) {
            entity.setIdCard(this.idCard);
        }
        if (this.username != null) {
            entity.setUsername(this.username);
        }
        if (this.password != null) {
            entity.setPassword(this.password);
        }
        if (this.phone != null) {
            entity.setPhone(this.phone);
        }
        if (this.address != null) {
            entity.setAddress(this.address);
        }
        if (this.credit != null) {
            entity.setCredit(this.credit);
        }
        if (this.isBlacklist != null) {
            entity.setIsBlacklist(this.isBlacklist);
        }
        if (this.createTime != null) {
            entity.setCreateTime(this.createTime);
        }
        if (this.lastLoginTime != null) {
            entity.setLastLoginTime(this.lastLoginTime);
        }
        if (this.icon != null) {
            entity.setIcon(this.icon);
        }
        if (this.type != null) {
            entity.setType(this.type);
        }
        return entity;
    }


    public Wrapper<User> toWrapper() {
        Wrapper<User> wrapper = new EntityWrapper<>();
        if (this.id != null) {
            wrapper.eq("id", this.id);
        }
        if (this.idCard != null) {
            wrapper.like("id_card", this.idCard);
        }
        if (this.username != null) {
            wrapper.like("username", this.username);
        }
        if (this.password != null) {
            wrapper.like("password", this.password);
        }
        if (this.phone != null) {
            wrapper.like("phone", this.phone);
        }
        if (this.address != null) {
            wrapper.like("address", this.address);
        }
        if (this.credit != null) {
            wrapper.eq("credit", this.credit);
        }
        if (this.isBlacklist != null) {
            wrapper.eq("is_blacklist", this.isBlacklist);
        }
        if (this.createTime != null) {
            wrapper.eq("create_time", this.createTime);
        }
        if (this.lastLoginTime != null) {
            wrapper.eq("last_login_time", this.lastLoginTime);
        }
        if (this.icon != null) {
            wrapper.like("icon", this.icon);
        }
        if (this.type != null) {
            wrapper.eq("type", this.type);
        }
        return wrapper;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(Integer isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idCard=" + idCard +
                ", username=" + username +
                ", password=" + password +
                ", phone=" + phone +
                ", address=" + address +
                ", credit=" + credit +
                ", isBlacklist=" + isBlacklist +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", icon=" + icon +
                ", type=" + type +
                "}";
    }
}







