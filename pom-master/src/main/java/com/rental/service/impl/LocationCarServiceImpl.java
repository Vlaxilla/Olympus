package com.rental.service.impl;

import com.rental.entity.LocationCar;
import com.rental.mapper.LocationCarMapper;
import com.rental.service.ILocationCarService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * <p>
 *  Service implementation class
 * </p>
 */
@Service

public class LocationCarServiceImpl extends ServiceImpl<LocationCarMapper, LocationCar> implements ILocationCarService {
}

