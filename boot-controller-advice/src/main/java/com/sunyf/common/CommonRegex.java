package com.sunyf.common;

import lombok.Data;

/**
 * @Description:通用正则表达式
 * @Author: sunyf
 * @Date: 2020/1/11 23:35
 */
@Data
public class CommonRegex {

    //身份证号正则（15位或者18位，最后一位可以为字母）
    public static final String IDCARD_REGEX = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    //手机号正则
    public static final String PHONE_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";


}
