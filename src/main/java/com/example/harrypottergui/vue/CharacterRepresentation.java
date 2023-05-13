package com.example.harrypottergui.vue;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CharacterRepresentation extends VBox {

    private ImageView imagePersonnage;
    private ProgressBar barreDeVie;
    private Label nomCombatant;

    public CharacterRepresentation(String imageUrl, String name) {

        this.imagePersonnage = new ImageView(new Image(getClass().getResourceAsStream(imageUrl)));
        this.barreDeVie = new ProgressBar();
        this.nomCombatant = new Label(name);
        this.barreDeVie.setProgress(1);
//        this.barreDeVie.setProgress(character.getLifePoint() / character.getMaxLifePoint());
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(this.nomCombatant);
        this.getChildren().add(this.imagePersonnage);
        this.getChildren().add(this.barreDeVie);


    }

    public ProgressBar getBarreDeVie() {
        return barreDeVie;
    }


}

