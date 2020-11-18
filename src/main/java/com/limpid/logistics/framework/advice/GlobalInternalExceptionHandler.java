package com.limpid.logistics.framework.advice;

import com.limpid.logistics.common.enumeration.GlobalConstant;
import com.limpid.logistics.common.exception.CustomException;
import com.limpid.logistics.common.vo.ResponseData;
import com.limpid.logistics.framework.annotation.InternalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局内部异常处理
 *
 * @auther cuiqiongyu
 * @create 2020/5/20 15:14
 */
@ControllerAdvice(annotations = InternalExceptionHandler.class)
public class GlobalInternalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public final ResponseEntity<Object> handlerCustomException(CustomException ex, WebRequest webRequest) {
        logger.error("异常信息{}", ex);
        return handlerExceptionResponse(ex.getCode(), ex.getMessage(), ex.getData());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public final ResponseEntity<Object> handlerRuntimeException(RuntimeException ex, WebRequest webRequest) {
        logger.error("异常信息{}", ex);
        return handlerExceptionResponse(GlobalConstant.ResponseState.SYSTEM_ERROR.getCode(), GlobalConstant.ResponseState.SYSTEM_ERROR.getMessage(), null);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public final ResponseEntity<Object> handlerException(Exception ex, WebRequest webRequest) {
        logger.error("异常信息{}", ex);
        return handlerExceptionResponse(GlobalConstant.ResponseState.SYSTEM_ERROR.getCode(), GlobalConstant.ResponseState.SYSTEM_ERROR.getMessage(), null);
    }

    public ResponseEntity<Object> handlerExceptionResponse(String code, String message, Object data) {
        ResponseData<Object> responseData = new ResponseData<>(code, message, data);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
