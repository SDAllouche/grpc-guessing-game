package ma.enset;

import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import ma.enset.stubs.Game;
import ma.enset.stubs.GuessingGameGrpc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class GameClient extends Application {

    private ObservableList<String> messages = FXCollections.observableArrayList();
    private ListView<String> messagesView = new ListView<>();
    private TextField name = new TextField();
    private TextField message = new TextField();
    private Button send = new Button();
    private GuessingGameGrpc.GuessingGameStub gameService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        setupAndShowPrimaryStage(stage);

        // Create a channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        // Create an async stub with the channel
        GuessingGameGrpc.GuessingGameStub gameService = GuessingGameGrpc.newStub(channel);

        // Open a connection to the server
        StreamObserver<Game.MessageRequest> request = gameService.guess(new StreamObserver<Game.MessageResponse>() {

                    // Handler for messages from the server
                    @Override
                    public void onNext(Game.MessageResponse value) {
                        // Display the message
                        Platform.runLater(() -> {
                            String response = value.getRespond();
                            if (response.contains("correct")) {
                                messages.add(response);
                                messagesView.scrollTo(messages.size());
                                send.setDisable(true);
                                message.setEditable(false);
                            }else {
                                messages.add(response);
                                messagesView.scrollTo(messages.size());
                            }

                        });
                    }


                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Disconnected due to error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Disconnected");
                    }
                });

        // Send button handler, create a message and send.
        send.setOnAction(e -> {

            String user=name.getText();
            String msg=message.getText();

            if (user != null && msg!=null) {
                // Create a message
                Game.MessageRequest requestMessage = Game.MessageRequest.newBuilder()
                        .setName(user)
                        .setNumber(Integer.parseInt(msg))
                        .build();

                // Send the message
                request.onNext(requestMessage);
                message.setText("");
            }
        });

        stage.setOnCloseRequest(e -> {
            request.onCompleted();
            channel.shutdown();
        });
    }

    private void setupAndShowPrimaryStage(Stage primaryStage) {

        messages.add("Guess a number between 1 an 100");
        messagesView.setItems(messages);
        send.setText("Send");
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        Label label=new Label("Player Name : ");
        label.setFont(Font.font("Lato", FontWeight.BOLD, 14));
        name.setPrefSize(300,35);
        HBox hBox1=new HBox(80,label,name);
        //hBox.setPrefHeight(80);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(10,0,20,0));
        root.setTop(hBox1);
        message.setPrefSize(300,35);
        send.setPrefSize(100,30);
        HBox hBox2=new HBox(70,message,send);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(20,0,10,0));
        root.setTop(hBox1);
        root.setCenter(messagesView);
        root.setBottom(hBox2);

        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(new Scene(root, 600, 500));

        primaryStage.show();
    }
}
