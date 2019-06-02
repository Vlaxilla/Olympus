package com.rental.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Serial number
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * The user id
     */
    @TableField("id_card")
    private String idCard;
    /**
     * Username
     */
    private String username;
    /**
     * Password
     */
    private String password;
    /**
     * Phone
     */
    private String phone;
    /**
     * Residential address
     */
    private String address;
    /**
     * Credit score
     */
    private Integer credit;
    /**
     *Mask indentification, 0;normal, 1:blocked
     */
    @TableField("is_blacklist")
    private Integer isBlacklist;
    /**
     *Account creation time
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * Last landing time
     */
    @TableField("last_login_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /**
     * The avatars
     */
    private String icon;
    /**
     * 1:ordinary user, 2:administrator?
     */
    private Integer type;


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




