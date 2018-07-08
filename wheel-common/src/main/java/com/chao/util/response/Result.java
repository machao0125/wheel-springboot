package com.chao.util.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一API响应结果封装
 * @author yaloo
 */
@Data
@ApiModel(value = "接口返回结果model", description = "返回结果中包含 data 和 message 两部分。如果message有值，且不为空，则代表操作发生了异常")
public final class Result<T> {
  @ApiModelProperty("请求结果:success或error")
  private boolean result;
  @ApiModelProperty("错误码")
  private int errCode;
  @ApiModelProperty("请求失败的异常信息")
  private String message;
  @ApiModelProperty("成功请求返回结果")
  private T content;

  public static <T> Result<T> newInstance() {
    return new Result<>();
  }

}