package com.example.harrypottergui.vue;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StartVue extends VBox {
    Label titleLabel = new Label("Harry Potter Game");
    Button startButton = new Button("Start Game");
//    Button gestureButton = new Button("Choose a gesture");

    public StartVue() {
        titleLabel.getStyleClass().add("title");
        startButton.getStyleClass().add("btn");
        this.getChildren().addAll(titleLabel, startButton);
//        this.getChildren().addAll(gestureButton);
    }


}

