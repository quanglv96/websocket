package org.example.WebSocket;


import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
@Service
public class CustomHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // Lấy session ID từ HttpServletRequest
//        String sessionId = request.getHeaders().getFirst("X-Session-Id"); // Tùy chỉnh header
//        if (sessionId == null) {
//            sessionId = request.getHeaders().getFirst("Cookie"); // Nếu có cookie, có thể lấy sessionId từ đó
//        }
//        // Lưu session ID vào attributes
//        attributes.put("sessionId", sessionId);
//        System.out.println("Session ID (beforeHandshake): " + sessionId);
        return true;  // Tiếp tục với kết nối WebSocket
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        // Ghi log hoặc thay đổi response nếu cần
    }
}


