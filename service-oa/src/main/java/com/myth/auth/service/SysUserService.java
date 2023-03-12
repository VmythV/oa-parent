package com.myth.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myth.model.system.SysUser;

/**
 * The interface Sys user service.
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * Update status.
     *
     * @param id     the id
     * @param status the status
     */
    void updateStatus(Long id, Integer status);
}