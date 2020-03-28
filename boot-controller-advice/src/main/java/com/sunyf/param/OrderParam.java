package com.sunyf.param;

import com.sunyf.common.CommonRegex;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @Description:创建订单参数
 * @Author: sunyf
 * @Date: 2020/1/11 23:35
 */
@Data
public class OrderParam {

    @NotNull(message = "商品编号不能为空")
    private Long goodsId;

    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @NotNull(message = "数量不能为空")
    private Integer amount;

    @Pattern(regexp = CommonRegex.PHONE_REGEX, message = "手机号格式错误")
    private String phoneNum;

    @Pattern(regexp = CommonRegex.IDCARD_REGEX, message = "身份证号格式错误")
    private String idcard;



}
