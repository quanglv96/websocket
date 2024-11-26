package org.example.WebSocket;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String recipient; // Người nhận
    private String message;   // Nội dung tin nhắn

}
