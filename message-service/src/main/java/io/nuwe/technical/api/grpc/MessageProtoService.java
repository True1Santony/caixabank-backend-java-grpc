package io.nuwe.technical.api.grpc;

import io.grpc.stub.StreamObserver;
import io.nuwe.technical.api.lib.MessageProto.*;
import io.nuwe.technical.api.lib.MessageServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.MessageService;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Example grpc server service implementation class.
 */
@GrpcService
public class MessageProtoService extends MessageServiceGrpc.MessageServiceImplBase {

    @Autowired
    private MessageService messageService;

    @Override
    public void getMessagesFromTo(MessageFromToRequest req, StreamObserver<MessageResponse> responseObserver) {

	long userSenderId = req.getUserSenderId();
	long userReceiverId = req.getUserReceiverId();

	List<Message> messages = messageService.getAllMessagesByUserSenderIdAndUserReceiverId(userSenderId, userReceiverId);

	MessageResponse.Builder messageBuilder = MessageResponse.newBuilder();


	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

	for(Message msg : messages){
	    messageBuilder.addMessages(MessageGrpc.newBuilder()
				      .setId(msg.getId())
				      .setUserSenderId(msg.getUserSenderId())
				      .setUserReceiverId(msg.getUserReceiverId())
				      .setBody(msg.getBody())
				      .setSentAt(msg.getSentAt().format(formatter))
				      .build());
	}

	MessageResponse reply  = messageBuilder.build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessagesReceivedFrom(MessageUserRequest req, StreamObserver<MessageResponse> responseObserver) {

	long userReceiverId = req.getUserId();

	List<Message> messages = messageService.getAllMessagesByUserReceiverId(userReceiverId);

	MessageResponse.Builder messageBuilder = MessageResponse.newBuilder();


	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

	for(Message msg : messages){
	    messageBuilder.addMessages(MessageGrpc.newBuilder()
				      .setId(msg.getId())
				      .setUserSenderId(msg.getUserSenderId())
				      .setUserReceiverId(msg.getUserReceiverId())
				      .setBody(msg.getBody())
				      .setSentAt(msg.getSentAt().format(formatter))
				      .build());
	}

	MessageResponse reply  = messageBuilder.build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessagesSentFrom(MessageUserRequest req, StreamObserver<MessageResponse> responseObserver) {

	long userSenderId= req.getUserId();

	List<Message> messages = messageService.getAllMessagesByUserSenderId(userSenderId);

	MessageResponse.Builder messageBuilder = MessageResponse.newBuilder();


	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

	for(Message msg : messages){
	    messageBuilder.addMessages(MessageGrpc.newBuilder()
				      .setId(msg.getId())
				      .setUserSenderId(msg.getUserSenderId())
				      .setUserReceiverId(msg.getUserReceiverId())
				      .setBody(msg.getBody())
				      .setSentAt(msg.getSentAt().format(formatter))
				      .build());
	}

	MessageResponse reply  = messageBuilder.build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
