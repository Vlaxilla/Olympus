package com.rental.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rental.QO.CarForm;
import com.rental.common.PageBean;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.rental.entity.User;
import com.rental.mapper.CarMapper;
import com.rental.service.ICarService;
import com.rental.vo.MakerVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *Service implementation class
 * </p>
 */
@Service

public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {
    @Override
    public String findCars(CarForm form) {
        Page<Car> page = form.getPage();
        if (page == null) {
            page = form.createPage();
        }
        page.setRecords(baseMapper.selectPage(page, form.toWrapper()));
        return Result.genResponse(Result.ok(new PageBean<>(page)));
    }

    @Override
    public Result findAvailableCar(CarForm form) {
        Page<Car> page = form.getPage();
        if (page == null) {
            page = form.createPage();
        }
        Wrapper<Car> wrapper = form.toWrapper();
        wrapper.eq("disable", 0);
        wrapper.ne("status", Car.NEW_CAR);
        page.setRecords(baseMapper.selectPage(page, wrapper));
        return Result.ok(new PageBean<>(page));
    }

    @Override
    public List<MakerVO> findMaker() {
        return baseMapper.findMaker();
    }
}

