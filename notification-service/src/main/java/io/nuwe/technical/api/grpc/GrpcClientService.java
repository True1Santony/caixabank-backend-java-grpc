package io.nuwe.technical.api.grpc;

import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import io.grpc.StatusRuntimeException;
import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.lib.NotificationProto.*;
import io.nuwe.technical.api.lib.NotificationServiceGrpc.NotificationServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;


@Service
public class GrpcClientService {

    @GrpcClient("frontend")
    private NotificationServiceBlockingStub notificationStub;

    public boolean pushNotification(final Notification notification){
		try { DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

			NotificationRequest request = NotificationRequest.newBuilder()
					.setMessageId(notification.getMessageId())
					.setUserSenderId(notification.getUserSenderId())
					.setUserReceiverId(notification.getUserReceiverId())
					.setBody(notification.getBody())
					.setSentAt(notification.getSentAt().format(formatter))
					.build();

			NotificationResponse res = notificationStub.pushNotification(request);

			return res.getNotificationArrived();

		} catch (final StatusRuntimeException e){
			System.err.println("Error enviando notificación: " + e.getMessage());
			return false;
		}
    }
}
