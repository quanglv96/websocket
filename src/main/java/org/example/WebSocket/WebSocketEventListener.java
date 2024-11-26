package org.example.WebSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.concurrent.ConcurrentHashMap;

@Component
//public class WebSocketEventListener{
public class WebSocketEventListener implements ApplicationListener<SessionConnectEvent> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    // Bản đồ ánh xạ giữa username và sessionId
    private final ConcurrentHashMap<String, String> userSessions = new ConcurrentHashMap<>();


    // Xử lý sự kiện khi kết nối WebSocket
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = headerAccessor.getFirstNativeHeader("username");
        if (username != null) {
            String sessionId = headerAccessor.getSessionId();
            userSessions.put(username, sessionId);
            System.out.println("Connected: Username = " + username + ", Session ID = " + sessionId);
            logger.info("User connected: {} with session ID: {}", username, sessionId);
        }
    }

//     Xử lý sự kiện khi ngắt kết nối WebSocket
    @EventListener
    public void handleWebSocketDisconnectConnectListener(SessionDisconnectEvent event) {
        String sessionId = event.getSessionId();
        userSessions.values().remove(sessionId);
        System.out.println("Disconnected: Session ID = " + sessionId);
    }

    // Phương thức lấy sessionId theo username
    public String getSessionIdByUsername(String username) {
        return userSessions.get(username);
    }

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        this.handleWebSocketConnectListener(sessionConnectEvent);
    }
}
