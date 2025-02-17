package io.nuwe.technical.api.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: message.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessageServiceGrpc {

  private MessageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MessageProto.MessageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesFromToMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessagesFromTo",
      requestType = io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest.class,
      responseType = io.nuwe.technical.api.lib.MessageProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesFromToMethod() {
    io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesFromToMethod;
    if ((getGetMessagesFromToMethod = MessageServiceGrpc.getGetMessagesFromToMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getGetMessagesFromToMethod = MessageServiceGrpc.getGetMessagesFromToMethod) == null) {
          MessageServiceGrpc.getGetMessagesFromToMethod = getGetMessagesFromToMethod =
              io.grpc.MethodDescriptor.<io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessagesFromTo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("GetMessagesFromTo"))
              .build();
        }
      }
    }
    return getGetMessagesFromToMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesReceivedFromMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessagesReceivedFrom",
      requestType = io.nuwe.technical.api.lib.MessageProto.MessageUserRequest.class,
      responseType = io.nuwe.technical.api.lib.MessageProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesReceivedFromMethod() {
    io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesReceivedFromMethod;
    if ((getGetMessagesReceivedFromMethod = MessageServiceGrpc.getGetMessagesReceivedFromMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getGetMessagesReceivedFromMethod = MessageServiceGrpc.getGetMessagesReceivedFromMethod) == null) {
          MessageServiceGrpc.getGetMessagesReceivedFromMethod = getGetMessagesReceivedFromMethod =
              io.grpc.MethodDescriptor.<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessagesReceivedFrom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("GetMessagesReceivedFrom"))
              .build();
        }
      }
    }
    return getGetMessagesReceivedFromMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesSentFromMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessagesSentFrom",
      requestType = io.nuwe.technical.api.lib.MessageProto.MessageUserRequest.class,
      responseType = io.nuwe.technical.api.lib.MessageProto.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
      io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesSentFromMethod() {
    io.grpc.MethodDescriptor<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse> getGetMessagesSentFromMethod;
    if ((getGetMessagesSentFromMethod = MessageServiceGrpc.getGetMessagesSentFromMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getGetMessagesSentFromMethod = MessageServiceGrpc.getGetMessagesSentFromMethod) == null) {
          MessageServiceGrpc.getGetMessagesSentFromMethod = getGetMessagesSentFromMethod =
              io.grpc.MethodDescriptor.<io.nuwe.technical.api.lib.MessageProto.MessageUserRequest, io.nuwe.technical.api.lib.MessageProto.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessagesSentFrom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.nuwe.technical.api.lib.MessageProto.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("GetMessagesSentFrom"))
              .build();
        }
      }
    }
    return getGetMessagesSentFromMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceStub>() {
        @java.lang.Override
        public MessageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceStub(channel, callOptions);
        }
      };
    return MessageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceBlockingStub>() {
        @java.lang.Override
        public MessageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceBlockingStub(channel, callOptions);
        }
      };
    return MessageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceFutureStub>() {
        @java.lang.Override
        public MessageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceFutureStub(channel, callOptions);
        }
      };
    return MessageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Gets all the messages sent from (userSenderId) to (userReceiverId)
     * </pre>
     */
    default void getMessagesFromTo(io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessagesFromToMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets all the messages received by (userReceiverId)
     * </pre>
     */
    default void getMessagesReceivedFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessagesReceivedFromMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets all the messages sent by (userSenderId)
     * </pre>
     */
    default void getMessagesSentFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessagesSentFromMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MessageService.
   */
  public static abstract class MessageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MessageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MessageService.
   */
  public static final class MessageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MessageServiceStub> {
    private MessageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets all the messages sent from (userSenderId) to (userReceiverId)
     * </pre>
     */
    public void getMessagesFromTo(io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessagesFromToMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets all the messages received by (userReceiverId)
     * </pre>
     */
    public void getMessagesReceivedFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessagesReceivedFromMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets all the messages sent by (userSenderId)
     * </pre>
     */
    public void getMessagesSentFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request,
        io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessagesSentFromMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MessageService.
   */
  public static final class MessageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessageServiceBlockingStub> {
    private MessageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets all the messages sent from (userSenderId) to (userReceiverId)
     * </pre>
     */
    public io.nuwe.technical.api.lib.MessageProto.MessageResponse getMessagesFromTo(io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessagesFromToMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets all the messages received by (userReceiverId)
     * </pre>
     */
    public io.nuwe.technical.api.lib.MessageProto.MessageResponse getMessagesReceivedFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessagesReceivedFromMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets all the messages sent by (userSenderId)
     * </pre>
     */
    public io.nuwe.technical.api.lib.MessageProto.MessageResponse getMessagesSentFrom(io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessagesSentFromMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MessageService.
   */
  public static final class MessageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MessageServiceFutureStub> {
    private MessageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets all the messages sent from (userSenderId) to (userReceiverId)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.nuwe.technical.api.lib.MessageProto.MessageResponse> getMessagesFromTo(
        io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessagesFromToMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets all the messages received by (userReceiverId)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.nuwe.technical.api.lib.MessageProto.MessageResponse> getMessagesReceivedFrom(
        io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessagesReceivedFromMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets all the messages sent by (userSenderId)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.nuwe.technical.api.lib.MessageProto.MessageResponse> getMessagesSentFrom(
        io.nuwe.technical.api.lib.MessageProto.MessageUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessagesSentFromMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MESSAGES_FROM_TO = 0;
  private static final int METHODID_GET_MESSAGES_RECEIVED_FROM = 1;
  private static final int METHODID_GET_MESSAGES_SENT_FROM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGES_FROM_TO:
          serviceImpl.getMessagesFromTo((io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest) request,
              (io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse>) responseObserver);
          break;
        case METHODID_GET_MESSAGES_RECEIVED_FROM:
          serviceImpl.getMessagesReceivedFrom((io.nuwe.technical.api.lib.MessageProto.MessageUserRequest) request,
              (io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse>) responseObserver);
          break;
        case METHODID_GET_MESSAGES_SENT_FROM:
          serviceImpl.getMessagesSentFrom((io.nuwe.technical.api.lib.MessageProto.MessageUserRequest) request,
              (io.grpc.stub.StreamObserver<io.nuwe.technical.api.lib.MessageProto.MessageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMessagesFromToMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.nuwe.technical.api.lib.MessageProto.MessageFromToRequest,
              io.nuwe.technical.api.lib.MessageProto.MessageResponse>(
                service, METHODID_GET_MESSAGES_FROM_TO)))
        .addMethod(
          getGetMessagesReceivedFromMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
              io.nuwe.technical.api.lib.MessageProto.MessageResponse>(
                service, METHODID_GET_MESSAGES_RECEIVED_FROM)))
        .addMethod(
          getGetMessagesSentFromMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.nuwe.technical.api.lib.MessageProto.MessageUserRequest,
              io.nuwe.technical.api.lib.MessageProto.MessageResponse>(
                service, METHODID_GET_MESSAGES_SENT_FROM)))
        .build();
  }

  private static abstract class MessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.nuwe.technical.api.lib.MessageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessageService");
    }
  }

  private static final class MessageServiceFileDescriptorSupplier
      extends MessageServiceBaseDescriptorSupplier {
    MessageServiceFileDescriptorSupplier() {}
  }

  private static final class MessageServiceMethodDescriptorSupplier
      extends MessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MessageServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageServiceFileDescriptorSupplier())
              .addMethod(getGetMessagesFromToMethod())
              .addMethod(getGetMessagesReceivedFromMethod())
              .addMethod(getGetMessagesSentFromMethod())
              .build();
        }
      }
    }
    return result;
  }
}
