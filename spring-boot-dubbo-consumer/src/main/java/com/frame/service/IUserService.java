package com.frame.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.core.Result;
import com.frame.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author project
 * @since 2020-01-08
 */
public interface IUserService {

    void removeById(Long id);

    void updateById(User user);

    User getById(Long id);

    Result login(User user);

    void register(User user);

    Result findListByPage(Integer currentPage, Integer pageCount);
}
