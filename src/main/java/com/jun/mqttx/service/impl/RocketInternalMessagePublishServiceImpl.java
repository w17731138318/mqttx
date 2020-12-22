package com.jun.mqttx.service.impl;

import com.alibaba.fastjson.JSON;
import com.jun.mqttx.entity.InternalMessage;
import com.jun.mqttx.service.IInternalMessagePublishService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * 基于 rocket 实现
 * @author wwx
 * @see DefaultInternalMessagePublishServiceImpl
 * @since v1.0.6
 */
public class RocketInternalMessagePublishServiceImpl implements IInternalMessagePublishService {

    private final RocketMQTemplate rocketMQTemplate;

    public RocketInternalMessagePublishServiceImpl(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @Override
    public <T> void publish(InternalMessage<T> internalMessage, String channel) {
        rocketMQTemplate.convertAndSend(channel, JSON.toJSONBytes(internalMessage));
        System.out.println("转发成功");
    }
}
