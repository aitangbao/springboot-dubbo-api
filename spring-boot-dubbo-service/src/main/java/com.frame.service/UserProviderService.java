package com.frame.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
public interface UserProviderService extends IService<User> {

    Result login(User user);

    void register(User user);

    Result findListByPage(Integer currentPage, Integer pageCount);
}
