package com.example.project.service;

import com.example.project.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class SimpleNotificationService implements NotificationService {

    @Override
    public void sendNotification(Notification notification) {
        System.out.println(notification);
    }
}
