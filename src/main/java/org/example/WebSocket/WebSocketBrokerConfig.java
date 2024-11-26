package org.example.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {
    @Resource
    private  CustomHandshakeInterceptor customHandshakeInterceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // Để gửi tin nhắn từ client tới server
        registry.enableSimpleBroker("/queue", "/topic");  // Để server gửi tin nhắn đến client
        registry.setUserDestinationPrefix("/user");  // Để gửi tin nhắn cá nhân tới user
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").addInterceptors(customHandshakeInterceptor).setAllowedOrigins("*");// Đăng ký WebSocket endpoint với SockJS
        registry.addEndpoint("/ws").setAllowedOrigins("*");// Đăng ký WebSocket endpoint với SockJS
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS(); // Đăng ký WebSocket endpoint với SockJS
    }

}
