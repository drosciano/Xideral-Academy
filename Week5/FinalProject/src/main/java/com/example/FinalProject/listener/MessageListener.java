package com.example.FinalProject.listener;

import com.example.FinalProject.config.MqConfig;
import com.example.FinalProject.entity.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MqConfig.QUEUE)
    public void listener(Message message) {
        System.out.println(message);
    }
}
