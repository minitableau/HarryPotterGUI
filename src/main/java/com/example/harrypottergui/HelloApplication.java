package com.example.harrypottergui;

import Game.Game;
import com.example.harrypottergui.vue.NameController;
import com.example.harrypottergui.vue.NameVue;
import com.example.harrypottergui.vue.StartController;
import com.example.harrypottergui.vue.StartVue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        Game.gui = true;
        this.stage = stage;
        showStartScene();
    }

    public void showStartScene() {
        StartVue startVue = new StartVue();
        StartController startController = new StartController(startVue, this);
        Scene scene = new Scene(startVue, 760, 529);
        stage.setTitle("Mon jeu");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}