package com.myth.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myth.model.system.SysMenu;
import com.myth.vo.system.AssginMenuVo;

import java.util.List;

/**
 * @author may
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 菜单树形数据
     * @return 菜单树形数据
     */
    List<SysMenu> findNodes();
    /**
     * 根据角色获取授权权限数据
     * @return
     */
    List<SysMenu> findSysMenuByRoleId(Long roleId);

    /**
     * 保存角色权限
     * @param  assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);
}