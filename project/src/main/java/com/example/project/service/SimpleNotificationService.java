package com.example.project.service;

import com.example.project.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class SimpleNotificationService implements NotificationService {

    private final TaskScheduler taskScheduler;

    @Autowired
    public SimpleNotificationService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Value("${notification.message}")
    private String defaultMessage;

    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending notification: " + notification.getMessage());
    }

    @Scheduled(fixedRateString = "${notification.interval}")
    public void sendScheduledNotification() {
        Notification notification = new Notification(defaultMessage, LocalDateTime.now());
        sendNotification(notification);
    }

    public void makeScheduledNotification(Notification notification) {
        LocalDateTime now = LocalDateTime.now();
        long delayMillis = Duration.between(now, notification.getTimestamp()).toMillis();
        Date executionTime = new Date(System.currentTimeMillis() + delayMillis);
        taskScheduler.schedule(() -> {
            sendNotification(new Notification(notification.getMessage(), notification.getTimestamp()));
        }, executionTime);
    }
}
