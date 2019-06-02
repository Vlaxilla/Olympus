package com.rental.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rental.entity.Car;
import com.rental.entity.Location;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 */
@Mapper
@Repository
public interface LocationMapper extends BaseMapper<Location> {

    List<Car> showCar(RowBounds rowBounds, @Param("ew") Wrapper<Location> locationWrapper,@Param("id") Integer id);
    List<Car> showCar(@Param("ew") Wrapper<Location> locationWrapper,@Param("id") Integer id);

    List<Car> showNoRelateCar(RowBounds rowBounds, @Param("ew")  Wrapper<Location> locationWrapper);

}
