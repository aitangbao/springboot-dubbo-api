package com.frame.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.core.Result;
import com.frame.core.ResultGenerator;
import com.frame.entity.User;
import com.frame.service.IUserService;
import com.frame.utils.JwtUtils;
import com.frame.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author project
 * @since 2020-01-08
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody @Valid User user) {
        return userService.login(user);

    }

    @PostMapping("/register")
    public Result register(@RequestBody @Valid User user) {
        userService.register(user);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        userService.removeById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("update")
    public Result update(@RequestBody User user){
        //密码不更新
        user.setPassword(null);
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("listByPage")
    public Result findListByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "10") Integer pageCount){
        return userService.findListByPage(currentPage, pageCount);

    }

    @GetMapping("getById/{id}")
    public Result findById(@PathVariable Long id){
        return ResultGenerator.genSuccessResult(userService.getById(id));
    }

}
