package com.rental.service.impl;

import com.rental.entity.Information;
import com.rental.mapper.InformationMapper;
import com.rental.service.IInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * <p>
 *  Service implementation calss?
 * </p>
 */
@Service

public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements IInformationService {
}

