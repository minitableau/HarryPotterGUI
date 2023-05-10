package com.example.harrypottergui.vue;

import GameElement.Core;
import GameElement.Wand;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Enemy;
import GameElement.characters.enemies.Troll;
import Level.*;
import com.example.harrypottergui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

import java.util.Objects;

import static utils.ScrollingInWindow.nextButton;
import static utils.ScrollingInWindow.stagetext;

public class StartController {

    private Stage stage;
    private StartVue startVue;
    private HelloApplication helloApplication;
    public static Wizard wizard = new Wizard("Nom pr test", null, null, null);
    public static Enemy enemy = new Troll();

    public StartController(StartVue startVue, HelloApplication helloApplication) {
        this.startVue = startVue;
        this.startVue.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        this.startVue.startButton.setOnAction(this::onPlayAction);
    }

    public void onPlayAction(ActionEvent e) {
        AbstractLevel[] levels = new AbstractLevel[]{
                new Level0(),
        };

        for (AbstractLevel level : levels) {
            level.startLevel(wizard);
            if (!wizard.isAlive()) break;



//                //TODO : Lancement combat
//                FightBoard fightBoard = new FightBoard();
//                fightBoard.creationFenetreJeu(fightBoard);
//                fightBoard.setGame();



        }
    }
}
