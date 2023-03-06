package com.myth.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myth.auth.mapper.SysRoleMapper;
import com.myth.auth.service.SysRoleService;
import com.myth.model.system.SysRole;
import org.springframework.stereotype.Service;

/**
 * @author may
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}