package com.rental.service;

import com.rental.QO.CarForm;
import com.rental.common.Result;
import com.rental.entity.Car;
import com.baomidou.mybatisplus.service.IService;
import com.rental.vo.MakerVO;

import java.util.List;

/**
 * <p>
 *  Service class?
 * </p>
 */
public interface ICarService extends IService<Car> {
    String findCars(CarForm form);
    Result findAvailableCar(CarForm form);
    List<MakerVO> findMaker();
}
