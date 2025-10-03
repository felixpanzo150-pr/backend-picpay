package tech.felicxpanzo.picpay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.felicxpanzo.picpay.client.NotificationClient;
import tech.felicxpanzo.picpay.entity.Transfer;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){

        try {
            logger.info("Sending notification...");

        notificationClient.sendNotification(transfer);
    } catch (Exception e) {
            logger.error("Error while sending notification", e);

        }
    }
}
