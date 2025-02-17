package io.nuwe.technical.api.grpc;

import io.grpc.stub.StreamObserver;
import io.nuwe.technical.api.lib.UserProto.*;
import io.nuwe.technical.api.lib.UserServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.UserService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserProtoService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserService userService;

    @Override
    public void getUser(UserRequest req, StreamObserver<UserResponse> responseObserver) {
	long id = (long)req.getId();
	Optional<User> optUser = this.userService.getUserById(id);

	final UserResponse reply;
	if (optUser.isPresent()){
	    User user = optUser.get();
	    reply = UserResponse.newBuilder()
		.setId(user.getId())
		.setName(user.getName())
		.setEmail(user.getEmail())
		.setAge(user.getAge())
		.setIsSubscribed(user.getIsSubscribed())
		.build();
	}else {
	    reply = UserResponse.newBuilder().setId(-1).build();
	}
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

	// el id es autogenerado, siempre devolverá un User a no ser que se quiera poner algun filtro para que no se repita ej: mail
	@Override
	public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver){
		User user = new User();//suscrito por defecto en el constructor.
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		//user.setSubscribed(true); // modificar si viene ya con el param en true or false por request

		userService.saveUser(user); // guardo al user

		CreateUserResponse response = CreateUserResponse.newBuilder()
				.setId(user.getId())
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
		boolean success = userService.deleteUser(request.getId());

		String message;
		if (success) {
			message = "User deleted successfully";
		} else {
			message = "User not found";
		}

		// respuesta
		DeleteUserResponse response = DeleteUserResponse.newBuilder()
				.setSuccess(success)
				.setMessage(message)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}
}
