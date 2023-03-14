package com.myth.auth.controller;

import com.myth.auth.service.SysUserService;
import com.myth.common.execption.OaException;
import com.myth.common.jwt.JwtHelper;
import com.myth.common.md5.MD5Utils;
import com.myth.common.result.Result;
import com.myth.model.system.SysUser;
import com.myth.vo.system.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 后台登录登出
 * </p>
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     *
     * @return 登录结果
     */
    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo) {
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());
        if (null == sysUser) {
            throw new OaException(201, "用户不存在");
        }
        if (!Objects.equals(MD5Utils.code(loginVo.getPassword()), loginVo.getPassword())) {
            throw new OaException(201, "密码错误");
        }
        if (sysUser.getStatus() == 0) {
            throw new OaException(201, "用户被禁用");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(sysUser.getId(), sysUser.getUsername()));
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        map.put("buttons", new ArrayList<>());
        map.put("routers", new ArrayList<>());
        return Result.ok(map);
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(map);
    }

    /**
     * 退出
     *
     * @return 退出
     */
    @PostMapping("logout")
    public Result logout() {
        return Result.ok();
    }

}