package com.gvozdev.serverchat;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatController implements
        Initializable {

    @FXML
    private Button button_send;
    @FXML
    private TextField text_message;
    @FXML
    private VBox v_box;
    @FXML
    private ScrollPane scroll_pane;

    private Server server;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            server = new Server(new ServerSocket(6663));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("-> Connection to Server run Failed!");
        }

        v_box.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scroll_pane.setVvalue((Double) t1);
            }
        });

        server.fromClientMessage(v_box);

        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String toSend = text_message.getText();
                if (!toSend.isEmpty()) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);
                    hBox.setPadding(new Insets(5,5,5,10));

                    Text text = new Text(toSend);
                    TextFlow textFlow = new TextFlow(text);
                    textFlow.setStyle("-fx-color: #fff; -fx-background-color: #22ab8be4; -fx-background-radius: 25px");
                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.WHITE);

                    hBox.getChildren().add(textFlow);
                    v_box.getChildren().add(hBox);

                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

                    server.sendMessageToClient(format.format(date)+" Server:\n"+toSend);
                    text_message.clear();
                }
            }
        });
    }

    public static void addLabel(String msgFromClient, VBox vBox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));

        Text text = new Text(msgFromClient);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: #b6bab849; -fx-background-radius: 25px");
        textFlow.setPadding(new Insets(5,10,5,10));


        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox);
            }
        });
    }
}