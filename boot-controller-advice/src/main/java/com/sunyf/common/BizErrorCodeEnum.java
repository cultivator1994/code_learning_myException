package com.sunyf.common;

/**
 * 业务错误码枚举
 */
public enum BizErrorCodeEnum implements BizErrorCode{

    /** 未指明的异常 */
    UNSPECIFIED(500001, "内部服务器错误，请稍后再试"),
    BIZ_DEAL_FAIL(500002, "业务处理失败"),

    // 通用异常
    REQUEST_ERROR(400000, "请求参数异常,请检查入参后再次调用：{0}"),
    PAGE_NUM_IS_NULL(400001,"页码不能为空"),
    PAGE_SIZE_IS_NULL(400002,"页数不能为空"),
    ID_IS_NULL(400003,"ID不能为空"),
    SEARCH_IS_NULL(400004,"搜索条件不能为空"),


    // 短信相关
    SEND_MASSAGE_FAIL(300001,"发送短消息失败"),
    SEND_MASSAGE_OFTEN(300002,"操作发送短消息太频繁,请稍后再试"),
    MESSAGE_TEMPLATE_UNDEFINED(300003,"短信模板未定义"),

    //支付相关
    CREATE_PAY_ORDER_FAIL(600001,"创建订单支付失败"),
    UPDATE_PAY_ORDER_FAIL(600002,"更新支付订单失败"),
    DEL_PAY_ORDER_FAIL(600003,"更新支付订单失败"),
    PAY_ORDER_NO_EXISTS(600004,"支付订单不存在"),
    REFUND_APPLY_NO_EXISTS(600005,"退款申请不存在"),
    VERIFY_NOT_PASS(600006,"验签"),
    RES_FAIL(600007,"响应失败"),
    PAY_CHANNEL_IS_NULL(600008,"支付渠道不能为空"),
    PAY_CHANNEL_PARAM_ERROR(600009,"支付订单渠道参数错误"),



            ;

    /** 错误码 */
    private final Integer code;

    /** 描述 */
    private final String description;

    /**
     * @param code 错误码
     * @param description 描述
     */
    private BizErrorCodeEnum(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据编码查询枚举。
     *
     * @param code 编码。
     * @return 枚举。
     */
    public static BizErrorCodeEnum getByCode(Integer code) {
        for (BizErrorCodeEnum value : BizErrorCodeEnum.values()) {
            if (code == value.getCode()) {
                return value;
            }
        }
        return UNSPECIFIED;
    }

    /**
     * 枚举是否包含此code
     * @param code 枚举code
     * @return 结果
     */
    public static Boolean contains(Integer code){
        for (BizErrorCodeEnum value : BizErrorCodeEnum.values()) {
            if (code == value.getCode()) {
                return true;
            }
        }
        return  false;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
