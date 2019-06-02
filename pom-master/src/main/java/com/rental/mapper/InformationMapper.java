package com.rental.mapper;

import com.rental.entity.Information;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * <p>
 *  Mapper Interface
 * </p>
 */
@Mapper
@Repository
public interface InformationMapper extends BaseMapper<Information> {

}
