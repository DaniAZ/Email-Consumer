package edu.mum.bloodbankrest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;




@SpringBootApplication
public class BloodbankrestApplication {
    public static final String EXCHANGE_NAME = "tips_tx";
    public static final String DEFAULT_PARSING_QUEUE = "default_parser_q";
    public static final String MESSAGING_QUEUE = "Message_Queue";
    public static final String ROUTING_KEY = "tips";

    @Bean
    public TopicExchange tipsExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(DEFAULT_PARSING_QUEUE);
    }
    @Bean
    public Queue messageParsingQueue() {
        return new Queue(MESSAGING_QUEUE);
    }

    @Bean
    public Binding queueToExchangeBinding() {
        return BindingBuilder.bind(defaultParsingQueue()).to(tipsExchange()).with(ROUTING_KEY);
    }


    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(BloodbankrestApplication.class, args);
    }

}
