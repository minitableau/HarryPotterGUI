package com.example.harrypottergui.vue;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.Enemy;
import Level.AbstractLevel;
import Level.Level0;
import com.example.harrypottergui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.Objects;


public class StartController {

    private Stage stage;
    private StartVue startVue;
    private HelloApplication helloApplication;
    public static Wizard wizard = new Wizard("Nom pr test", null, null, null);
    public static Enemy enemy;

    public StartController(StartVue startVue, HelloApplication helloApplication,Stage stage) {
        this.stage = stage;
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
        stage.close();
    }
}
