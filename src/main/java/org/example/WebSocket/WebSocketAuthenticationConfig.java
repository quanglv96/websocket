package org.example.WebSocket;//package nth.module.personalinsurance.WebSocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//public class WebSocketAuthenticationConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new UserInterceptor());
//    }
//}
//
//@Component
//class UserInterceptor implements org.springframework.messaging.support.ChannelInterceptor {
//
//    @Override
//    public org.springframework.messaging.Message<?> preSend(org.springframework.messaging.Message<?> message,
//                                                            org.springframework.messaging.MessageChannel channel) {
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//        if (StompHeaderAccessor.CONNECT.equals(accessor.getCommand())) {
//            String username = accessor.getFirstNativeHeader("username");
//            if (username != null) {
//                accessor.setUser(() -> username);
//            }
//        }
//        return message;
//    }
//}
