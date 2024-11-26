package org.example.WebSocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @Resource
    private WebSocketEventListener webSocketEventListener;

    @PostMapping("/send-private-message")
    //demo
    public String sendPrivateMessage(@RequestBody MessageDto messageDto) {
        String sessionId = webSocketEventListener.getSessionIdByUsername(messageDto.getRecipient());
        if (sessionId != null) {
            messagingTemplate.convertAndSendToUser(sessionId, "/queue/messages", messageDto.getMessage());
            System.out.println("send success to sessionId: "+sessionId +" from username: "+messageDto.getRecipient());
            return "Message sent to " + messageDto.getRecipient();
        }
        return "User not connected!";
    }
}

