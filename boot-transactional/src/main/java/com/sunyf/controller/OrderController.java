package com.sunyf.controller;

import com.sunyf.common.ResponseJson;
import com.sunyf.dao.entity.OrderItemEntity;
import com.sunyf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2019/12/30 00:05
 */
@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/add/order")
    @ResponseBody
    public ResponseJson addOrder(long goodsId, int count) throws Exception{
        long userId = 100L;
        OrderItemEntity orderItemEntity = orderService.addOrder(goodsId, userId, count);
        return ResponseJson.success(orderItemEntity);
    }
}
