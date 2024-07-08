package org.example.flowing.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "notification_topic", groupId = "notification_group")
    public void consume (String message) {
        try {
            Notification notification = objectMapper.readValue(message, Notification.class);

            notificationService.sendNotification(notification);
            System.out.println("Message: " + notification.getMessage() + " sent to " + notification.getRecipient());
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
    }
}
