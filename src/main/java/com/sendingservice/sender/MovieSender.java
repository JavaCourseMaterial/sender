package com.sendingservice.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MovieSender {

    private static final Logger logger = LoggerFactory.getLogger(MovieSender.class.getName());

    @Autowired
    private Movie movie;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedRate = 3000)
    public void send() {
        this.rabbitTemplate.convertAndSend(queue.getName(), movie);
        logger.info(" [x] Sent '" + movie + "'");
    }
}
