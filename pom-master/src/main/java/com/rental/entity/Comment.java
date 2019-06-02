package com.rental.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;


public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The order number
     */
    @TableId("order_id")
    private String orderId;
    /**
     * The order score
     */
    @TableField("comment_score")
    private Integer commentScore;
    /**
     * Order service evaluation
     */
    @TableField("comment_desc")
    private String commentDesc;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    @Override
    public String toString() {
        return "Comment{" +
        "orderId=" + orderId +
        ", commentScore=" + commentScore +
        ", commentDesc=" + commentDesc +
        "}";
    }
}
