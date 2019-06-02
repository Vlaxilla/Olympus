package com.rental.service;


import com.baomidou.mybatisplus.service.IService;
import com.rental.QO.LocationForm;
import com.rental.QO.OrdersForm;
import com.rental.entity.Car;
import com.rental.entity.Orders;

import java.util.List;

/**
 * <p>
 *  Service class??
 * </p>
 */
public interface IOrdersService extends IService<Orders> {
    String findOrders(OrdersForm form);

    List<Car> getCarList(OrdersForm form);
}
