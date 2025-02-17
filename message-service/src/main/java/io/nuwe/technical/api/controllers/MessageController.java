package io.nuwe.technical.api.controllers;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.*;

import io.nuwe.technical.api.lib.UserProto.UserResponse;

import io.nuwe.technical.api.grpc.GrpcClientService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/message/all")
    public ResponseEntity<List<Message>> getAllMessages(){
	List<Message> messages = messageService.getAllMessages();

	if (messages.isEmpty()){
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/messages/to/{id}")
    public ResponseEntity<?> getMessagesByUserReceiverId(@PathVariable("id") long id){

	Optional<UserResponse> user = grpcClientService.getUser(id);

	if (!user.isPresent()){
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	assert user.isPresent() == true;
	assert user.get().getId() >= 0;

	List<Message> messages = messageService.getAllMessagesByUserReceiverId(id);

	if (messages.isEmpty()){
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/messages/from/{id}")
    public ResponseEntity<?> getMessagesByUserSenderId(@PathVariable("id") long id){

	Optional<UserResponse> user = grpcClientService.getUser(id);

	if (!user.isPresent()){
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	assert user.isPresent() == true: "User should be present";
	assert user.get().getId() >= 0: "User Id should be greater than 0 and is == " + user.get().getId();
	assert id < 5: "Id should be less than 5 and == " + id;

	List<Message> messages = messageService.getAllMessagesByUserSenderId(id);


	UserResponse u = user.get();
	String res = "User: " + u.getName() + " and Id " + u.getId();

	if (messages.isEmpty()){
	    return new ResponseEntity<String>(res, HttpStatus.NO_CONTENT);
	}

	return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/messages/from/{from}/to/{to}")
    public ResponseEntity<List<Message>> getMessagesByUserSenderId(@PathVariable("from") long userSenderId, @PathVariable("to") long userReceiverId){

	Optional<UserResponse> userSender = grpcClientService.getUser(userSenderId);
	Optional<UserResponse> userReceiver = grpcClientService.getUser(userReceiverId);

	if (!userSender.isPresent() || !userReceiver.isPresent()){
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	List<Message> messages = messageService.getAllMessagesByUserSenderIdAndUserReceiverId(userSenderId, userReceiverId);

	if (messages.isEmpty()){
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") int id){
	Optional<Message> optMessage = messageService.getMessageById(id);

	if (optMessage.isPresent()){
	    return new ResponseEntity<>(optMessage.get(), HttpStatus.OK);
	}

	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	/* TODO: TASK 2 */

    @PostMapping("/message")
    public ResponseEntity<?> createMessage(@RequestBody Message message){

		Optional<UserResponse> userSender = grpcClientService.getUser(message.getUserSenderId());
		Optional<UserResponse> userReceiver = grpcClientService.getUser(message.getUserReceiverId());

		if (!userSender.isPresent() || !userReceiver.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		message.setSentAt(java.time.LocalDateTime.now());
		Message savedMessage = messageService.saveMessage(message);

		// Solo enviar notificación si el receptor está suscrito
		if (userReceiver.get().getIsSubscribed()) {
			boolean notificationSent = grpcClientService.pushNotification(savedMessage);
			if (!notificationSent) {
				return new ResponseEntity<>("Message saved but notification failed", HttpStatus.PARTIAL_CONTENT);
			}
		}

		return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
		
	}

    @DeleteMapping("/message/{id}")
    public ResponseEntity<Message> deleteMessageById(@PathVariable("id") int id){

	Optional<Message> optMessage = messageService.getMessageById(id);

	if (optMessage.isPresent()){
	    Message deletedMessage = messageService.deleteMessage(optMessage.get());
	    return new ResponseEntity<>(deletedMessage, HttpStatus.OK);
	}

	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/message/all")
    public ResponseEntity<Message> deleteAllMessages(){
	messageService.deleteAll();

	return new ResponseEntity<>(HttpStatus.OK);
    }

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUnexpectedException(Exception ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("An unexpected error occurred: " + ex.getMessage());
	}
}
