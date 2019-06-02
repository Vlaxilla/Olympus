package com.rental.mapper;

import com.rental.entity.Comment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * <p>
 *  Mapper interface
 * </p>
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}
