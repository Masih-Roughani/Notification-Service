# Simple Notification Service

A Spring Boot application that demonstrates RESTful web services, scheduled tasks, and dependency injection through a notification service.

## Features

- REST API for sending notifications
- Scheduled notifications every 30 seconds
- Startup notification on application launch
- Configuration via `application.properties`
- Swagger API documentation

## Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+

### Run the Application
```bash
mvn spring-boot:run
```

Application starts on `http://localhost:8080`

## Configuration

Edit `src/main/resources/application.properties`:
```properties
notification.message=Hello from scheduled task!
notification.interval=30000
```

## API Endpoints

### Swagger UI
Access API documentation at: `http://localhost:8080/swagger-ui.html`

### Send Notification
```bash
POST /api/notifications/send
Content-Type: application/json

{
    "message": "Test notification",
    "timestamp": "2025-08-01T10:30:00"
}
```

### Schedule Notification (Optional)
```bash
POST /api/notifications/schedule
Content-Type: application/json

{
    "message": "Future notification", 
    "timestamp": "2025-08-01T15:30:00"
}
```

## Testing

### cURL Example
```bash
curl -X POST http://localhost:8080/api/notifications/send \
  -H "Content-Type: application/json" \
  -d '{"message": "Hello World!", "timestamp": "2025-08-01T10:30:00"}'
```

### Expected Console Output
- **Startup**: "Application started! Sending a test notification."
- **Scheduled**: "Hello from scheduled task!" (every 30 seconds)
- **API**: "Sending notification: [your message]"

## Project Structure
```
src/main/java/com/example/project/
├── ProjectApplication.java
├── controller/NotificationController.java
├── service/
│   ├── NotificationService.java
│   ├── SimpleNotificationService.java
│   └── StartupNotificationRunner.java
└── model/Notification.java
```
