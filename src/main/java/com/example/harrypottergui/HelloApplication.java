package com.example.harrypottergui;

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

//    public void showNameScene(){
//        NameVue nameVue = new NameVue();
//        NameController nameController = new NameController(nameVue);
//        Scene scene = new Scene(nameVue, 760, 529);
//        stage.setTitle("Choix du nom");
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch();
    }
}