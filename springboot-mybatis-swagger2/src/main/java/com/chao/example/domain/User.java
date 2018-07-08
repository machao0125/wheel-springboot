package com.chao.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户里面的组织字段就是指用户所属的组织，比如张三输属于软件研发部。
 * 用户---》组织 是多对一的关系。
 * 用户---》角色 是多对多关系，由一张关联表来保存这种多对多关系。
 *
 * @author machao
 */
@ApiModel(value = "User", description = "用户")
@Data
public class User {

  @ApiModelProperty(value = "主键")
  private Long id;

  @ApiModelProperty(value = "账号")
  private String account;

  @ApiModelProperty(value = "密码")
  //@JsonIgnore
  private String password;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "手机号码")
  private String mobile;

  @ApiModelProperty(value = "加入时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  @ApiModelProperty(value = "是否启用")
  private Boolean enable;

  @ApiModelProperty(value = "密码修改时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date lastPasswordResetDate;
}