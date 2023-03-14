package com.myth.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myth.model.system.SysUser;

import java.util.Map;

/**
 * The interface Sys user service.
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * Gets by username.
     *
     * @param username the username
     * @return the by username
     */
    SysUser getByUsername(String username);
    /**
     * Update status.
     *
     * @param id     the id
     * @param status the status
     */
    void updateStatus(Long id, Integer status);
    /**
     * 根据用户名获取用户登录信息
     * @param username username
     * @return 登录信息
     */
    Map<String, Object> getUserInfo(String username);
}