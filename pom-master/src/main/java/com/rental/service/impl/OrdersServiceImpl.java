package com.rental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rental.QO.LocationForm;
import com.rental.QO.OrdersForm;
import com.rental.common.PageBean;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.rental.entity.Location;
import com.rental.entity.Orders;
import com.rental.mapper.LocationMapper;
import com.rental.mapper.OrdersMapper;
import com.rental.service.IOrdersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Service implementation class
 * </p>
 */
@Service

public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public String findOrders(OrdersForm form) {
        Page<Orders> page = form.getPage();
        if (page == null) {
            page = form.createPage();
        }
        page.setRecords(baseMapper.selectPage(page, form.toWrapper()));
        return Result.genResponse(Result.ok(new PageBean<>(page)));
    }

    @Override
    public List<Car> getCarList(OrdersForm form) {
        Location location = new Location();
        location.setLocationName(form.getPickupLocation());
        location = locationMapper.selectOne(location);
        if (location == null) {
            return new ArrayList<>();
        }
        return locationMapper.showCar(new EntityWrapper<>(), location.getLocationId());
    }


}

