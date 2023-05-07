package com.example.harrypottergui.vue;

import javafx.event.ActionEvent;
import utils.ScrollingInWindow;

public class NameController {
    NameVue nameVue;

    public NameController(NameVue nameVue) {
        this.nameVue = nameVue;
        this.nameVue.check.setOnAction(this::onButtonAction);
    }

    public void onButtonAction(ActionEvent e) {
        String FURNITURE_MESSAGE = "Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + nameVue.name.getText() + ". Avant de partir pour Poudlard, il y a quelques formalités à régler. Tout d'abord, il vous faut  vos fournitures : un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !\" \n\tHagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse.";
        ScrollingInWindow.printInWindow(FURNITURE_MESSAGE);
    }
}
