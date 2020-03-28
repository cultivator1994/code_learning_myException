package com.sunyf.common;

/**
 * 自定义业务异常
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected final Integer    code;

    public BusinessException() {
        this.code = null;
    }

    public BusinessException(final String message) {
        super(message);
        this.code = null;
    }

    public BusinessException(final Throwable cause) {
        super(cause);
        this.code = null;
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
        this.code = null;
    }

    public BusinessException(final Integer code, final String message) {
        super(message);
        this.code = code;
    }

    public BusinessException (BizErrorCode bizErrorCode) {
        super(bizErrorCode.getDescription());
        this.code = bizErrorCode.getCode();
    }

    public BusinessException(final Integer code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

}