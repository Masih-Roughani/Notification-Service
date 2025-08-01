package com.example.project.controller;

import com.example.project.model.Notification;
import com.example.project.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        try {
            notificationService.sendNotification(notification);
            return ResponseEntity.ok("Notification sent");
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Failed to send notification: " + e.getMessage());
        }
    }

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleNotification(@RequestBody Notification notification) {
        try {
            notificationService.makeScheduledNotification(notification);
            return ResponseEntity.ok("Notification scheduled");
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Failed to schedule notification: " + e.getMessage());
        }
    }
}
