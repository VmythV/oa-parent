package com.myth.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myth.model.system.SysRole;
import com.myth.vo.system.SysRoleQueryVo;

/**
 * The interface Sys role service.
 *
 * @author may
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * Gets sys role page.
     *
     * @param page           the page
     * @param limit          the limit
     * @param sysRoleQueryVo the sys role query vo
     * @return the sys role page
     */
    IPage<SysRole> getSysRolePage(Long page, Long limit, SysRoleQueryVo sysRoleQueryVo);
}