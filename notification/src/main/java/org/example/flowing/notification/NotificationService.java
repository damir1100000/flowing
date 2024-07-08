package org.example.flowing.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void sendNotification(Notification notification) {
        redisTemplate.convertAndSend("notification_channel", notification);
    }
}