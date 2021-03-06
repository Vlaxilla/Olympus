package com.rental.mapper;

import com.rental.entity.Car;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rental.vo.MakerVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 */
@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {

    List<MakerVO> findMaker();
}
