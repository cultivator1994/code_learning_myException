package com.sunyf.controller;

import com.alibaba.fastjson.JSON;
import com.sunyf.common.*;
import com.sunyf.param.OrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description: 订单控制类
 * @Author: York.Hwang
 * @Date: 2020/1/12 21:18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("create")
    public CommonResponse createOrder(@Valid @RequestBody OrderParam orderParam){
        LOG.info("order creating , param={}", JSON.toJSON(orderParam));
        if (orderParam.getGoodsId() == 1L) {
            //模拟业务处理异常情况
            throw new BusinessException(BizErrorCodeEnum.PAY_CHANNEL_IS_NULL);
        }
        if(orderParam.getGoodsId() == 2L){
            //模拟业务处理失败情况
            return CommonResponse.fail();
        }
        //模拟业务处理成功情况,并返回数据
        return CommonResponse.success(1000L);
    }




}
