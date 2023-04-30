package ma.enset.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ma.enset.service.GameService;

import java.io.IOException;

public class GameServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        Server server= ServerBuilder.forPort(9999)
                .addService(new GameService())
                .build();
        server.start();
        server.awaitTermination();
    }

}
