package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.Comment;




public class CommentForm extends BaseInfoForm {

    /**
     * Order number
     */
    private String orderId;
    /**
     * Order score
     */
    private Integer commentScore;
    /**
     * Order service evaluation
     */
    private String commentDesc;


    public Comment toComment(Comment entity) {
        if (this.orderId != null) {
            entity.setOrderId(this.orderId);
        }
        if (this.commentScore != null) {
            entity.setCommentScore(this.commentScore);
        }
        if (this.commentDesc != null) {
            entity.setCommentDesc(this.commentDesc);
        }
        return entity;
    }


    public Wrapper<Comment> toWrapper() {
        Wrapper<Comment> wrapper = new EntityWrapper<>();
        if (this.orderId != null) {
            wrapper.like("order_id", this.orderId);
        }
        if (this.commentScore != null) {
            wrapper.eq("comment_score", this.commentScore);
        }
        if (this.commentDesc != null) {
            wrapper.like("comment_desc", this.commentDesc);
        }
        return wrapper;
    }


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
