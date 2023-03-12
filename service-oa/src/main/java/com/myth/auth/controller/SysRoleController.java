package com.myth.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myth.auth.service.SysRoleService;
import com.myth.common.result.Result;
import com.myth.model.system.SysRole;
import com.myth.vo.system.AssginRoleVo;
import com.myth.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("findAll")
    @ApiOperation(value = "获取全部角色列表")
    public Result<List<SysRole>> findAll() {
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }


    /**
     * @param page           当前页
     * @param limit          每页显示记录数
     * @param sysRoleQueryVo 条件对象
     * @return 分页数据
     */
    @GetMapping("{page}/{limit}")
    @ApiOperation("条件分页查询")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo) {

        IPage<SysRole> pageModel = sysRoleService.getSysRolePage(page, limit, sysRoleQueryVo);

        return Result.ok(pageModel);
    }

    @GetMapping("get/{id}")
    @ApiOperation(value = "获取")
    public Result get(@PathVariable Long id) {
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }


    @PostMapping("save")
    @ApiOperation(value = "新增角色")
    public Result save(@RequestBody @Validated SysRole role) {
        boolean isSuccess = sysRoleService.save(role);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public Result updateById(@RequestBody SysRole role) {
        boolean isSuccess = sysRoleService.updateById(role);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean isSuccess = sysRoleService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean isSuccess = sysRoleService.removeByIds(idList);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId) {
        Map<String, Object> roleMap = sysRoleService.findRoleByUserId(userId);
        return Result.ok(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}