package com.chao.example.controller;


import com.chao.example.domain.User;
import com.chao.example.service.impl.UserServiceImpl;
import com.chao.util.response.Result;
import com.chao.util.response.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yaloo
 */
@Api(description = "用户管理API")
@RequestMapping("/api/users")
@RestController
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  @ApiOperation(value="分页查询")
  @GetMapping("")
  public Result getList(){
    return ResultGenerator.genSuccessResult(userService.listAll());
  }

  @ApiOperation(value="添加用户",tags = {"1s"})
  @ApiImplicitParam(name = "user", required = true, dataType = "User")
  @PostMapping("")
  public Result<Void> save(@RequestBody User user){
    userService.insert(user);
    return ResultGenerator.genSuccessResult();
  }

  @ApiOperation(value="查询用户", notes="根据用户主键，查询用户详情")
  @ApiImplicitParam(name = "id", paramType = "path" ,required = true, dataType = "int")
  @GetMapping(value = "/{id}")
  public Result<User> get(@PathVariable("id") long id){
    User u = userService.getOne(id);
    return ResultGenerator.genSuccessResult(u);
  }

  /**
   * 批量删除
   */
  @ApiOperation(value="批量删除", notes="根据用户Id批量删除",tags = {"1s"})
  @ApiImplicitParam(name = "ids", allowMultiple = true, required = true, dataType = "Long")
  @DeleteMapping("/{ids}")
  public Result<Void> batchDelete(@PathVariable List<Long> ids){
    userService.deleteByIds(ids);
    return ResultGenerator.genSuccessResult();
  }

  @ApiOperation(value="停用账号", notes="根据用户Id停用账号",tags = {"2s"})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户Id", paramType = "path", required = true, dataType = "int")
  })
  @PostMapping(value = "/stop/{id}")
  public Result<Void> stop(@PathVariable Long id){
    userService.stop(id);
    return ResultGenerator.genSuccessResult();
  }

  @ApiOperation(value="启用账号", notes="根据用户Id启用账号",tags = {"2s"})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户Id", paramType = "path", required = true, dataType = "Long")
  })
  @PostMapping("/enable/{id}")
  public Result<Void> enable(@PathVariable Long id){
    userService.enable(id);
    return ResultGenerator.genSuccessResult();
  }
}