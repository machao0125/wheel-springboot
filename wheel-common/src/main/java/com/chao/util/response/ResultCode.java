package com.chao.util.response;
/**
 * 响应码枚举，参考HTTP状态码的语义
 * @author machao
 */
public enum ResultCode {
  //成功
  SUCCESS(200,"success"),
  //未认证（签名错误）
  UNAUTHORIZED(401,"未认证（签名错误）"),
  //接口不存在
  NOT_FOUND(404,"接口不存在"),
  //服务器内部错误
  INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
  //参数错误
  ILLEGAL_PARAMS(400, "request params invalid");

  ResultCode(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  private int code;

  private String message;

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}