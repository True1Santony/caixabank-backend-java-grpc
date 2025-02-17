package io.nuwe.technical.api.grpc;

import io.grpc.stub.StreamObserver;
import io.nuwe.technical.api.lib.NotificationProto.*;
import io.nuwe.technical.api.lib.NotificationServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.NotificationService;
import io.nuwe.technical.api.grpc.GrpcClientService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class NotificationProtoService extends NotificationServiceGrpc.NotificationServiceImplBase {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private GrpcClientService grpcClientService;

	private static final Logger log = LoggerFactory.getLogger(NotificationProtoService.class);
	private final Set<String> processingRequests = ConcurrentHashMap.newKeySet();

   @Override
    public void pushNotification(NotificationRequest req, StreamObserver<NotificationResponse> responseObserver) {
       String notificationKey = req.getMessageId() + "-" + req.getUserReceiverId();

       if (!processingRequests.add(notificationKey)) {
           log.warn("Notificación ya en proceso: {}", notificationKey);
           responseObserver.onError(new RuntimeException("Notification already being processed"));
           return;
       }

       try {
           log.info("Procesando notificación para usuario {}", req.getUserReceiverId());

           Notification notification = new Notification(
                   req.getMessageId(),
                   req.getUserSenderId(),
                   req.getUserReceiverId(),
                   req.getBody(),
                   LocalDateTime.parse(req.getSentAt(), DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"))
           );
           notificationService.saveNotification(notification);

           boolean arrived = grpcClientService.pushNotification(notification);

           NotificationResponse response = NotificationResponse.newBuilder()
                   .setNotificationArrived(arrived)
                   .build();

           responseObserver.onNext(response);
           responseObserver.onCompleted();
       } catch (Exception e) {
           log.error("Error al procesar la notificación", e);
           responseObserver.onError(e);
       } finally {
           processingRequests.remove(notificationKey);
       }
   }



}
