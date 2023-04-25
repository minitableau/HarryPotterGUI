package com.example.harrypottergui.vue;

import GameElement.Core;
import GameElement.Wand;
import GameElement.characters.Wizard;
import com.example.harrypottergui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import utils.ScrollingInWindow;


import java.util.Objects;

import static utils.ScrollingInWindow.nextButton;
import static utils.ScrollingInWindow.stagetext;

public class StartController {

    private Stage stage;
    private StartVue startVue;
    private HelloApplication helloApplication;

    public StartController(StartVue startVue, HelloApplication helloApplication) {
        this.startVue = startVue;
        this.startVue.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        this.startVue.startButton.setOnAction(this::onPlayAction);

//        this.startVue.gestureButton.setOnAction(this::onGestureAction);


    }

    public void onPlayAction(ActionEvent e) {
        String HAGRID_ARRIVAL_MESSAGE = "Vous entendez frapper à la porte. En l'ouvrant, vous trouvez un homme gigantesque, un demi-géant, avec une barbe sauvage et des yeux pétillants.\n\"Bonjour, je suis Rubeus Hagrid gardien des clés et des lieux à Poudlard\", dit-il en souriant. \"Je viens chercher un jeune sorcier de 11 ans pour l'emmener à Poudlard.\n Et vous êtes...?";
        ScrollingInWindow.printInWindow(HAGRID_ARRIVAL_MESSAGE);
        nextButton.setOnAction(event -> {
//            HelloApplication.showNameScene();

            ChooseName();
        });

    }

    public void ChooseName() {
        stagetext.close();
        Stage dialog = new Stage();
        VBox dialogVBox = new VBox();
        TextField name = new TextField("Entrez votre nom");
        Button check = new Button("Valider");
        dialogVBox.getChildren().addAll(name, check);
        Scene dialogScene = new Scene(dialogVBox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.show();

        check.setOnAction(event -> {
            dialog.close();
            String FURNITURE_MESSAGE = "Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + name.getText() + ". Avant de partir pour Poudlard, il y a quelques formalités à régler. Tout d'abord, il vous faut  vos fournitures : un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !\" \n\tHagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse.";
            ScrollingInWindow.printInWindow(FURNITURE_MESSAGE);
            nextButton.setOnAction(event1 -> {
                //TODO Create a wizard ailleurs
                Wizard wizard = new Wizard(null, null, null, null);
                Wand wand1 = new Wand();
                Core core1 = wand1.getCore();
                String INTRODUCTION_MESSAGE = "Vous découvrez une rue pleine de boutiques en tout genre : magasins d'animaux, de balais, baguettes magiques et une banque. \nVous passez à la Gringotts banque récupérer votre argent dans le coffre 687. Le gobelin vous indique que vous disposez de " + wizard.getMoney() + " mornilles.\nVous passez ensuite chez Olivenders acheter votre baguette. Il vous reconnaît directement et se rappelle très bien des baguettes de vos parents, il vous tend alors une baguette faite avec un coeur en " + wand1.getCore().type + " faisant " + wand1.getSize() + " cm" + " et vous demande de faire le geste.";
                ScrollingInWindow.printInWindow(INTRODUCTION_MESSAGE);
            });
        });

    }

    public void onGestureAction(ActionEvent e) {
        Stage dialog = new Stage();
        VBox dialogVBox = new VBox();
        Button smallGestureButton = new Button("Small Gesture");
        Button largeGestureButton = new Button("Large Gesture");
        dialogVBox.getChildren().addAll(smallGestureButton, largeGestureButton);
        Scene dialogScene = new Scene(dialogVBox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.show();


        smallGestureButton.setOnAction(event -> {
            dialog.close();
            String CHOICE1 = "\nVous faites un petit geste.";
            ScrollingInWindow.printInWindow(CHOICE1);
        });

        largeGestureButton.setOnAction(event -> {
            dialog.close();
            String CHOICE2 = "\nVous faites un grand geste.";
            ScrollingInWindow.printInWindow(CHOICE2);
        });


    }


}
