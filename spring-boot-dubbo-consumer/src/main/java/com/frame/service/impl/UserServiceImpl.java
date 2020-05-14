package com.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.core.Result;
import com.frame.core.ResultGenerator;
import com.frame.entity.User;
import com.frame.service.IUserService;
import com.frame.service.UserProviderService;
import com.frame.utils.JwtUtils;
import com.frame.utils.MD5Utils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author project
 * @since 2020-01-08
 */
@Service
public class UserServiceImpl implements IUserService {

    @Reference(version = "1.0.0")
    private UserProviderService userProviderService;

    @Override
    public void removeById(Long id) {
        userProviderService.removeById(id);
    }

    @Override
    public void updateById(User user) {
        userProviderService.updateById(user);
    }

    @Override
    public User getById(Long id) {
        return userProviderService.getById(id);
    }

    @Override
    public Result login(User user) {
        return userProviderService.login(user);
    }

    @Override
    public void register(User user) {
        userProviderService.register(user);
    }

    @Override
    public Result findListByPage(Integer currentPage, Integer pageCount) {
        return userProviderService.findListByPage(currentPage, pageCount);
    }
}
