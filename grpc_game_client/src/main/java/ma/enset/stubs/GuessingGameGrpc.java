package ma.enset.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: game.proto")
public final class GuessingGameGrpc {

  private GuessingGameGrpc() {}

  public static final String SERVICE_NAME = "GuessingGame";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.stubs.Game.MessageRequest,
      ma.enset.stubs.Game.MessageResponse> getGuessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "guess",
      requestType = ma.enset.stubs.Game.MessageRequest.class,
      responseType = ma.enset.stubs.Game.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.stubs.Game.MessageRequest,
      ma.enset.stubs.Game.MessageResponse> getGuessMethod() {
    io.grpc.MethodDescriptor<ma.enset.stubs.Game.MessageRequest, ma.enset.stubs.Game.MessageResponse> getGuessMethod;
    if ((getGuessMethod = GuessingGameGrpc.getGuessMethod) == null) {
      synchronized (GuessingGameGrpc.class) {
        if ((getGuessMethod = GuessingGameGrpc.getGuessMethod) == null) {
          GuessingGameGrpc.getGuessMethod = getGuessMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stubs.Game.MessageRequest, ma.enset.stubs.Game.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "GuessingGame", "guess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Game.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stubs.Game.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GuessingGameMethodDescriptorSupplier("guess"))
                  .build();
          }
        }
     }
     return getGuessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GuessingGameStub newStub(io.grpc.Channel channel) {
    return new GuessingGameStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GuessingGameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GuessingGameBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GuessingGameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GuessingGameFutureStub(channel);
  }

  /**
   */
  public static abstract class GuessingGameImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Game.MessageRequest> guess(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Game.MessageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGuessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGuessMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ma.enset.stubs.Game.MessageRequest,
                ma.enset.stubs.Game.MessageResponse>(
                  this, METHODID_GUESS)))
          .build();
    }
  }

  /**
   */
  public static final class GuessingGameStub extends io.grpc.stub.AbstractStub<GuessingGameStub> {
    private GuessingGameStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GuessingGameStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessingGameStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GuessingGameStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.stubs.Game.MessageRequest> guess(
        io.grpc.stub.StreamObserver<ma.enset.stubs.Game.MessageResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGuessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GuessingGameBlockingStub extends io.grpc.stub.AbstractStub<GuessingGameBlockingStub> {
    private GuessingGameBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GuessingGameBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessingGameBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GuessingGameBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class GuessingGameFutureStub extends io.grpc.stub.AbstractStub<GuessingGameFutureStub> {
    private GuessingGameFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GuessingGameFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GuessingGameFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GuessingGameFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GUESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GuessingGameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GuessingGameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GUESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.guess(
              (io.grpc.stub.StreamObserver<ma.enset.stubs.Game.MessageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GuessingGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GuessingGameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.stubs.Game.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GuessingGame");
    }
  }

  private static final class GuessingGameFileDescriptorSupplier
      extends GuessingGameBaseDescriptorSupplier {
    GuessingGameFileDescriptorSupplier() {}
  }

  private static final class GuessingGameMethodDescriptorSupplier
      extends GuessingGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GuessingGameMethodDescriptorSupplier(String methodName) {
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
      synchronized (GuessingGameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GuessingGameFileDescriptorSupplier())
              .addMethod(getGuessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
