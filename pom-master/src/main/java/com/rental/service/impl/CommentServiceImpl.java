package com.rental.service.impl;

import com.rental.entity.Comment;
import com.rental.mapper.CommentMapper;
import com.rental.service.ICommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * <p>
 *  Service implementation class
 * </p>
 */
@Service

public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
}

