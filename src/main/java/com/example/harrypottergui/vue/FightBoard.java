package com.example.harrypottergui.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.ScrollingInWindow;


public class FightBoard {
    private FightBoard fightBoard;
    private static final int G_WIDTH = 1000;
    private static final int G_HEIGHT = 800;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;

    private GridPane gridPane1;
    private GridPane gridPane2;
    public static Label textDialogue;

    private HBox HBhero;
    private HBox HBennemy;
    private HBox HBsubscene;

    private final static String imageWizard = "/images/wizard.png";
    private static String imageEnemy = "/images/troll.png";
    private final static String imageBoss = "/images/BOSS.png";
    private final static String textBook = "/images/Book.jpg";


    public FightBoard() {
        initialisationStage();
    }


    private void initialisationStage() {
        gamePane = new AnchorPane();
        HBhero = new HBox();
        HBhero.setSpacing(10.);
        AnchorPane.setTopAnchor(HBhero, 200.);
        AnchorPane.setLeftAnchor(HBhero, 75.);
        gamePane.getChildren().add(HBhero);
        HBennemy = new HBox();
        AnchorPane.setTopAnchor(HBennemy, 10.);
        AnchorPane.setLeftAnchor(HBennemy, 520.);
        gamePane.getChildren().add(HBennemy);
        gameScene = new Scene(gamePane, G_WIDTH, G_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        Image imageDialogue = new Image(getClass().getResourceAsStream(textBook));
        ImageView imageViewDialogue = new ImageView(imageDialogue);
        AnchorPane.setLeftAnchor(imageViewDialogue, 50.);
        AnchorPane.setTopAnchor(imageViewDialogue, 500.);
        gamePane.getChildren().add(imageViewDialogue);
        textDialogue = new Label();
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 25);
        textDialogue.setFont(font);
        AnchorPane.setLeftAnchor(textDialogue, 100.);
        AnchorPane.setTopAnchor(textDialogue, 550.);
        gamePane.getChildren().add(textDialogue);
        HBsubscene = new HBox();
        AnchorPane.setTopAnchor(HBsubscene, 500.);
        AnchorPane.setLeftAnchor(HBsubscene, 650.);
        HBsubscene.setAlignment(Pos.CENTER);
        gamePane.getChildren().add(HBsubscene);
        //TODO : VERIF PRINT DU TEXTE
        ScrollingInWindow.setMessage("\nQue voulez-vous faire sachant que " + StartController.enemy.getName() + " \nse situe à " + StartController.enemy.getDistance() + " mètres et à " + StartController.enemy.getLifePoint() + " points de vie ?");
//        setMessage("\nQue voulez-vous faire sachant que " + StartController.enemy.getName() + " \nse situe à " + StartController.enemy.getDistance() + " mètres et à " + StartController.enemy.getLifePoint() + " points de vie ?");

        //TODO : NOM + IMAGE ENNEMI
        HBhero.getChildren().add(new CharacterRepresentation(imageWizard, StartController.wizard.getName()));
        HBennemy.getChildren().add(new CharacterRepresentation(imageEnemy, "NOM ENNEMI"));
    }


    public void creationFenetreJeu(FightBoard fightBoard) {
        this.fightBoard = fightBoard;
        gameStage.show();
    }

    public void setGame() {
        ButtonGrid buttonGrid = new ButtonGrid();
        buttonGrid.setVgap(10);
        HBsubscene.getChildren().add(buttonGrid);
        HBsubscene.setPadding(new Insets(20, 20, 20, 20));
        HBsubscene.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        HBox.setMargin(buttonGrid, new Insets(30, 30, 30, 30));
        initGrille(buttonGrid);
    }

    private void initGrille(ButtonGrid buttonGrid) {
        buttonGrid.getChildren().clear();
        Label throwing = new Label(StartController.enemy.whatAWizardCanDoAgainstMe());
        throwing.setPrefWidth(200);
        throwing.setPrefHeight(40);
//        throwing.setOnAction(event -> );

        Label gettingCloser = new Label("2 -> Se rapprocher");
//        Button gettingCloser = new Button("Se rapprocher");
        gettingCloser.setPrefWidth(200);
        gettingCloser.setPrefHeight(40);
//        gettingCloser.setOnAction(event -> {
//            gettingCloser(buttonGrid);
//        });
        Label chooseSpell = new Label("3 -> Choisir un sort");
        chooseSpell.setPrefWidth(200);
        chooseSpell.setPrefHeight(40);
//        chooseSpell.setOnAction(event -> {
//            chooseSpell(buttonGrid);
//        });
        Button openBackpack = new Button("4 -> Ouvrir ton sac");
        openBackpack.setPrefWidth(200);
        openBackpack.setPrefHeight(40);
//        openBackpack.setOnAction(event -> {
//            openBackpack(buttonGrid);
//        });
        buttonGrid.add(throwing, 0, 0, 2, 1);
        buttonGrid.add(gettingCloser, 0, 1, 2, 1);
        buttonGrid.add(chooseSpell, 0, 2, 2, 1);
        buttonGrid.add(openBackpack, 0, 3, 2, 1);

        Button choiceButton = new Button("Faire son choix");
        choiceButton.setOnAction(event -> StartController.wizard.fight(StartController.enemy));

        buttonGrid.add(choiceButton,  0, 4, 2, 1);
    }

//    private void setMessage(String string) {
//        final Animation animation = new Transition() {
//            {
//                setCycleDuration(Duration.millis(1000));
//            }
//
//            protected void interpolate(double frac) {
//                final int length = string.length();
//                final int n = Math.round(length * (float) frac);
//                textDialogue.setText(string.substring(0, n));
//            }
//        };
//        animation.play();
//    }

    public void throwing(ButtonGrid buttonGrid) {
        // TODO VERIF SI possible d'appeler fight directement et comprend 2 si clic sur le bouton 1 ,2 sur le 2 ....
        StartController.enemy.onWizardAttack(StartController.wizard);

    }

    public void gettingCloser(ButtonGrid buttonGrid) {

    }

    public void chooseSpell(ButtonGrid buttonGrid) {

    }

    public void openBackpack(ButtonGrid buttonGrid) {

    }
}
