package com.rental.service;


import com.baomidou.mybatisplus.service.IService;
import com.rental.QO.LocationForm;
import com.rental.entity.Location;

/**
 * <p>
 *  Service class?
 * </p>
 */
public interface ILocationService extends IService<Location> {
    String findLocations(LocationForm form);

    String showCar(LocationForm form);

    String showNoRelateCar(LocationForm form);
}
