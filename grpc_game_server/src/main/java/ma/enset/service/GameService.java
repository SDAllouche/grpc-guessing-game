package ma.enset.service;

import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Game;
import ma.enset.stubs.GuessingGameGrpc;

import java.util.LinkedHashSet;
import java.util.Random;

public class GameService extends GuessingGameGrpc.GuessingGameImplBase {

    int random=new Random().nextInt(100);

    private static LinkedHashSet<StreamObserver<Game.MessageResponse>> observers = new LinkedHashSet<>();

    @Override
    public StreamObserver<Game.MessageRequest> guess(StreamObserver<Game.MessageResponse> responseObserver) {
        // Add response observer to the list
        observers.add(responseObserver);

        // Handler for client messages
        return new StreamObserver<Game.MessageRequest>() {

            @Override
            public void onNext(Game.MessageRequest value) {

                String name=value.getName();
                int number= value.getNumber();

                if (number >random) {
                    Game.MessageResponse response= Game.MessageResponse.newBuilder()
                            .setRespond("Your number "+number + " is High")
                            .build();
                    responseObserver.onNext(response);
                } else if (number <random) {
                    Game.MessageResponse response= Game.MessageResponse.newBuilder()
                            .setRespond("Your number "+number + " is Low")
                            .build();
                    responseObserver.onNext(response);
                }
                else if (number==random) {

                    // Notify all observers
                    for (StreamObserver<Game.MessageResponse> observer : observers) {
                        if(responseObserver.equals(observer)){
                            Game.MessageResponse response= Game.MessageResponse.newBuilder()
                                    .setRespond("the number "+number + " is correct, Congratulations!!")
                                    .build();
                            responseObserver.onNext(response);
                        }else {
                            Game.MessageResponse response= Game.MessageResponse.newBuilder()
                                    .setRespond("Game Over, the winner is : "+name+" and "+number + " is the correct number!!")
                                    .build();
                            observer.onNext(response);
                        }
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                t.getMessage();
                observers.remove(responseObserver);
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }
        };
    }
}
