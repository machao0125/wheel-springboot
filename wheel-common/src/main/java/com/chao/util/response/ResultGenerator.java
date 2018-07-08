package com.chao.util.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口返回对象封装
 * @author yaloo
 */
public final class ResultGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultGenerator.class);

  /**
   *
   * @param success 接口状态
   * @param data 返回数据<T>类型
   * @param message  message
   * @param resultCode resultCode
   * @param <T> 返回数据<T>类型
   * @return Result
   */
  private static <T> Result<T> genResult(final boolean success,final T data, final String message, final int resultCode) {
    Result<T> result = Result.newInstance();
    result.setResult(success);
    result.setContent(data);
    result.setMessage(message);
    result.setErrCode(resultCode);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("generate rest result:{}", result);
    }
    return result;
  }

  /**
   *
   * @param success 接口状态
   * @param data 返回数据<T>类型
   * @param resultCode ResultCode
   * @param <T> 返回数据<T>类型
   * @return Result
   */
  private static <T> Result<T> genResult(final boolean success, final T data,
      final ResultCode resultCode) {
    return genResult(success, data, resultCode.getMessage(), resultCode.getCode());
  }

  /**
   * success
   * @param data 返回数据
   * @param <T>  返回数据<T>类型
   * @return Result<T>
   */
  public static <T> Result<T> genSuccessResult(final T data) {
    return genResult(true, data, ResultCode.SUCCESS);
  }

  /**
   * error
   * @param error error enum
   * @return Result
   */
  public static Result genErrorResult(final ResultCode error) {
    return genResult(false, null, error);
  }

  /**
   * success no message
   * @return Result
   */
  public static Result genSuccessResult() {
    return genSuccessResult(null);
  }
}
