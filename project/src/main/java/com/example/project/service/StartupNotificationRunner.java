package com.example.project.service;

import com.example.project.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StartupNotificationRunner implements CommandLineRunner {

    private final NotificationService notificationService;

    @Autowired
    public StartupNotificationRunner(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void run(String... args) {
        notificationService.sendNotification(new Notification("Starting here", LocalDateTime.now()));
    }
}
