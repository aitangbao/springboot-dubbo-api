package com.frame.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frame.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author project
 * @since 2020-01-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
