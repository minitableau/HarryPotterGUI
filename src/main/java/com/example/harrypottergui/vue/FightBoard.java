package com.example.harrypottergui.vue;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.Enemy;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    public static Stage gameStage;
    private GridPane gridPane1;
    private GridPane gridPane2;
    public static Label textDialogue;

    public static HBox HBhero;
    public static HBox HBenemy;
    private HBox HBsubscene;

    private final static String imageWizard = "/images/wizard.png";
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
        HBenemy = new HBox();
        AnchorPane.setTopAnchor(HBenemy, 10.);
        AnchorPane.setLeftAnchor(HBenemy, 520.);
        gamePane.getChildren().add(HBenemy);
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
        HBenemy.getChildren().add(new CharacterRepresentation(StartController.enemy.getUrl(), StartController.enemy.getName()));
    }


    public void creationFenetreJeu(FightBoard fightBoard) {
        this.fightBoard = fightBoard;
        gameStage.show();
        Timeline task = FightBoard.setBarWizard((StartController.wizard), ((CharacterRepresentation) FightBoard.HBhero.getChildren().get(0)).getBarreDeVie());
        task.playFromStart();
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
        Label throwing = new Label("1 : " + StartController.enemy.whatAWizardCanDoAgainstMe());
        throwing.setPrefWidth(200);
        throwing.setPrefHeight(40);
//        throwing.setOnAction(event -> );

        Label gettingCloser = new Label("2 : Se rapprocher");
//        Button gettingCloser = new Button("Se rapprocher");
        gettingCloser.setPrefWidth(200);
        gettingCloser.setPrefHeight(40);
//        gettingCloser.setOnAction(event -> {
//            gettingCloser(buttonGrid);
//        });
        Label chooseSpell = new Label("3 : Choisir un sort");
        chooseSpell.setPrefWidth(200);
        chooseSpell.setPrefHeight(40);
//        chooseSpell.setOnAction(event -> {
//            chooseSpell(buttonGrid);
//        });
        Label openBackpack = new Label("4 : Ouvrir ton sac");
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

        buttonGrid.add(choiceButton, 0, 4, 2, 1);
    }

    public static Timeline setBarWizard(Wizard wizard, ProgressBar bar) {
        Timeline task = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(bar.progressProperty(), bar.getProgress())
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(bar.progressProperty(), wizard.getLifePoint() / (wizard.getMaxLifePoint() * 1.0))
                )
        );

        return task;
    }

    public static Timeline setBarEnemy(Enemy enemy, ProgressBar bar) {
        Timeline task = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(bar.progressProperty(), bar.getProgress())
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(bar.progressProperty(), enemy.getLifePoint() / (enemy.getMaxLifePoint() * 1.0))
                )
        );

        return task;
    }
}
