package com.frame.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frame.core.Result;
import com.frame.core.ResultGenerator;
import com.frame.core.ServiceException;
import com.frame.entity.User;
import com.frame.service.UserProviderService;
import com.frame.provider.dao.UserMapper;
import com.frame.utils.JwtUtils;
import com.frame.utils.MD5Utils;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author project
 * @since 2020-01-08
 */
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserProviderService {

    @Override
    public Result login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User userO = this.getOne(queryWrapper);
        if (userO == null) {
            return ResultGenerator.genFailResult("账号未找到");
        }
        if (!MD5Utils.Encrypt(user.getPassword(),true).equals(userO.getPassword())) {
            return ResultGenerator.genFailResult("密码错误");
        }
        String token = JwtUtils.geneJsonWebToken(user);
        user.setToken(token);
        user.setPassword("");
        return ResultGenerator.genSuccessResult(user);
    }

    @Override
    public void register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User userO = this.getOne(queryWrapper);
        if (userO != null) {
            throw new ServiceException("账号已存在");
        }
        user.setPassword(MD5Utils.Encrypt(user.getPassword(),true));
        this.save(user);
    }

    @Override
    public Result findListByPage(Integer currentPage, Integer pageCount) {
        Page page = new Page(currentPage, pageCount);
        IPage<User> iPage = this.page(page);
        return ResultGenerator.genSuccessResult(iPage);
    }
}
