package com.sendingservice.sender;

import com.rabbitmq.client.AMQP;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SenderApplication {

	@Autowired
	MovieSender movieSender;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SenderApplication.class, args);
		SenderApplication application = context.getBean(SenderApplication.class);
		application.process(application);
	}

	public void process(SenderApplication application) {

		MovieSender sender = application.movieSender;
		sender.send();
	}

	@Bean
	public Movie getMovie() {
		return new Movie();
	}

	@Bean
	public Queue getQueue() {
		return new Queue("MovieQueue");
	}

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
