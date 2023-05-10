package Level;

import GameElement.*;
import GameElement.characters.Wizard;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

import static utils.ScrollingInWindow.nextButton;

public class Level0 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        String HAGRID_ARRIVAL_MESSAGE = "Vous entendez frapper à la porte. En l'ouvrant, vous trouvez un homme gigantesque, un demi-géant, avec une barbe sauvage et des yeux pétillants.\n\"Bonjour, je suis Rubeus Hagrid gardien des clés et des lieux à Poudlard\", dit-il en souriant. \"Je viens chercher un jeune sorcier de 11 ans pour l'emmener à Poudlard.\n" + "Et vous êtes...?";
        ScrollingInWindow.printInWindow(HAGRID_ARRIVAL_MESSAGE);
        nextButton.setOnAction(event -> {
            Stage dialog = new Stage();
            VBox dialogVBox = new VBox();
            TextField name = new TextField("Entrez votre nom");
            Button check = new Button("Valider");
            wizard.setName(name.getText());
            dialogVBox.getChildren().addAll(name, check);
            Scene dialogScene = new Scene(dialogVBox, 200, 100);
            dialog.setScene(dialogScene);
            dialog.show();

            check.setOnAction(event1 -> {
                dialog.close();
                String FURNITURE_MESSAGE = "Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + name.getText() + ". Avant de partir pour Poudlard, il y a quelques formalités à régler. Tout d'abord, il vous faut  vos fournitures : un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !\" \n\tHagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse.";
                ScrollingInWindow.printInWindow(FURNITURE_MESSAGE);
                nextButton.setOnAction(event2 -> {
                    Wand wand1 = new Wand();
                    Core core1 = wand1.getCore();
                    String INTRODUCTION_MESSAGE = "Vous découvrez une rue pleine de boutiques en tout genre : magasins d'animaux, de balais, baguettes magiques et une banque. \nVous passez à la Gringotts banque récupérer votre argent dans le coffre 687. Le gobelin vous indique que vous disposez de " + wizard.getMoney() + " mornilles.\nVous passez ensuite chez Olivenders acheter votre baguette. Il vous reconnaît directement et se rappelle très bien des baguettes de vos parents, il vous tend alors une baguette faite avec un coeur en " + wand1.getCore().type + " faisant " + wand1.getSize() + " cm" + " et vous demande de faire le geste.";
                    ScrollingInWindow.printInWindow(INTRODUCTION_MESSAGE);
                    nextButton.setOnAction(event3 -> {
                        readGesture();
                        nextButton.setOnAction(event4 -> {
                            String BAD_GESTURE_MESSAGE = "\nVous tuez le poisson de M. Olivander \n";
                            ScrollingInWindow.printInWindow(BAD_GESTURE_MESSAGE);
                            nextButton.setOnAction(event5 -> {
                                Core core;
                                Wand wand;
                                do {
                                    wand = new Wand();
                                    core = wand.getCore();
                                } while (core == core1);
                                wizard.setWand(wand);
                                String WAND_MESSAGE = "\"Heu non sûrement pas celle-ci !\" s'exclame-t-il. \nIl vous tend alors une autre baguette dont le coeur est en " + wand.getCore().type + " faisant " + wand.getSize() + " cm" + " et vous demande de faire à nouveau le geste.";
                                ScrollingInWindow.printInWindow(WAND_MESSAGE);
                                nextButton.setOnAction(event6 -> {
                                    readGesture();
                                    nextButton.setOnAction(event7 -> {
                                        String MAGIC_WAND = "\nM. Olivender n'en revient pas ! Il connait toutes les baguettes qu'il vend et celle qui vous à choisi est faite à partir de " + wizard.getWand().getCore().type + " il est persuadé \nque vous aller accomplir de grandes choses car il y peu de sorciers qui ont des baguettes faite à partir de " + wizard.getWand().getCore().type + " et ils se sont tous démarqués !\nVous sortez de la boutique et Hagrid vous attend avec un animal.";
                                        ScrollingInWindow.printInWindow(MAGIC_WAND);
                                        nextButton.setOnAction(event8 -> {
                                            int animalChoice = animalChoice();
                                            Pet animalChosen = Pet.values()[animalChoice - 1];
                                            wizard.setPet(animalChosen);
                                            nextButton.setOnAction(event9 -> {
                                                String ANIMAL_NAME = "\nHagrid vous demande alors comment vous allez l'appeler :";
                                                ScrollingInWindow.printInWindow(ANIMAL_NAME);
                                                nextButton.setOnAction(event10 -> {
                                                    String nameAnimal = InteractionUtils.askForString("Nom de votre annimal : ");
                                                    nextButton.setOnAction(event11 -> {
                                                        String ARRIVAL_AT_HOGWARTS = "Dites bonjour à " + nameAnimal + " votre " + animalChosen.type + " !\n" + "\n\tHagrid vous amène alors à la gare de Londres en vous donnant votre billet pour Poudlard voie 9_3/4" + "\n\nVous demandez à un groupe de jeunes un peu plus âgés qui ont le même style de bagage que vous : \"Comment se rendre à la voie 9_3/4\"? \nTrès gentiment, ils vous montrent le chemin : il faut foncer dans un pilier ! \nVous foncez dans le pilier avec un peu d'appréhension, mais vous arrivez bien sur le quai. Le train s'apprête à partir, vous décidez alors de monter à bord du Poudlard Express. \nVous rejoignez votre cabine, déposez vos affaires et : ";
                                                        ScrollingInWindow.printInWindow(ARRIVAL_AT_HOGWARTS);
                                                        nextButton.setOnAction(event12 -> {
                                                            trainChoice(wizard);
                                                            nextButton.setOnAction(event13 -> {
                                                                SortingHat sortingHat = new SortingHat();
                                                                House[] houses = sortingHat.houses;

                                                                String SCHOOL_RULES = "Vous retrouvez Hagrid sur le quai qui demande a tous les passagers de le suivre pour les amener aux portes de Poudlard où le professeur McGonagall vous attend.\nUne fois arrivé, le professeur McGonagall vous souhaite la bienvenue à Poudlard et vous explique que vous allez être réparti dans différentes maisons, \nelles ont pour nom : "
                                                                        + houses[0] + ", " + houses[1] + ", " + houses[2] + ", " + houses[3]
                                                                        + ". \nPendant votre séjour à l'école, votre maison sera comme votre deuxième famille. Vos réussites rapporteront des points à votre maison et les infractions vous en feront perdre. \nÀ la fin de chaque année, la maison avec le plus de points gagnera une coupe. Tout est près vous allez pouvoir rentrer !\nVous entrez et arrivez dans une grande salle de reception où les élèves plus agés vous attendent, au bout de celle-ci vous apercevais un chapeau étrange \navec derrière lui plusieurs professeurs. Un très vielle homme au centre se lève prend la parole : \nBonjour à tous ! Je suis Albus Dumbledore le directeur de Poudlard, avant que la cérémonie de répartition ne commence je souhaite vous énoncer quelques règles à respecter : \n\tIl est formellement interdit de pénétrer dans la foret.\n\tD'autre part, le consierge M. Rusard souhaite vous rappelez que le couloir du troisième étage de l'aile droite est également interdit à toute personne qui ne veut pas mourir !\nJe déclare la cérémonie de répartition ouverte. Lorsque je vous appellerai, avancez-vous, je placerai alors le choixpeau magique sur votre tête et il vous donnera votre maison.\nCommençons," + " Eloise Midgen" + " !";
                                                                ScrollingInWindow.printInWindow(SCHOOL_RULES);
                                                                nextButton.setOnAction(event14 -> {
                                                                    House eloiseHouse = sortingHat.sort();
                                                                    String ELOISE_SORTING_HAT = "\t- " + "Choixpeau" + " : \"Hhhaa voyons voir, Hummm ok " + eloiseHouse + " !\"\nAu tour de : " + "Vincent Crabbe" + " !";
                                                                    ScrollingInWindow.printInWindow(ELOISE_SORTING_HAT);
                                                                    House vincentHouse = sortingHat.sort();
                                                                    if (wizard.getFriends().size() != 0) {
                                                                        wizard.getFriends().get(0).setHouse(eloiseHouse);
                                                                        wizard.getFriends().get(1).setHouse(vincentHouse);
                                                                    }

                                                                    nextButton.setOnAction(event15 -> {
                                                                        String VINCENT_SORTING_HAT = "\t- " + "Choixpeau" + " : \"Hummm avec toi pas la moindre hesitation " + vincentHouse + " !\"\nPuis : " + name + " !";
                                                                        ScrollingInWindow.printInWindow(VINCENT_SORTING_HAT);
                                                                        House characterHouse = sortingHat.sort(1);
                                                                        nextButton.setOnAction(event16 -> {
                                                                            String CHARACTER_SORTING_HAT = "\n\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Disons " + characterHouse + " !\"";
                                                                            ScrollingInWindow.printInWindow(CHARACTER_SORTING_HAT);
                                                                            nextButton.setOnAction(event17 -> {
                                                                                String MEETINGS_AT_HOGWARTS = "\nVous allez vous asseoir avec votre maison et rencontrer : Fleur Delacour qui à l'air de connaitre beaucoup de chose sur la magie. Elle devient votre ami. \nVous rencontrer aussi Bartemius Croupton qui se moque de vous et votre amie.";
                                                                                ScrollingInWindow.printInWindow(MEETINGS_AT_HOGWARTS);
                                                                                wizard.addFriend(new Friend("Fleur Delacour", characterHouse));
                                                                                wizard.setHouse(characterHouse);
                                                                                characterHouse.setHouseBonus(wizard);
                                                                                nextButton.setOnAction(event18 -> {
                                                                                    if (!wizard.isAlive()) return;
                                                                                    new Level1().startLevel(wizard);
                                                                                });
                                                                            });
                                                                        });
                                                                    });
                                                                });
                                                            });

                                                        });
                                                    });
                                                });
                                            });
                                        });

                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    }

    private void readGesture() {
        int choice = InteractionUtils.askForInt("\nChoisissez un geste : " +
                "\n1 : Faire un petit geste\n2 : Faire un grand geste", 1, 2);
        if (choice == 1) {
            String CHOICE1 = "\nVous faites un petit geste.";
            ScrollingInWindow.printInWindow(CHOICE1);
        }
        if (choice == 2) {
            String CHOICE2 = "\nVous faites un grand geste.";
            ScrollingInWindow.printInWindow(CHOICE2);

        }
    }

    private int animalChoice() {
        String PRINT_ALL_ANIMAL = "";
        for (Pet pet : Pet.values()) {
            String PRINT_ANIMAL = pet.ordinal() + 1 + " : " + pet.type;
            PRINT_ALL_ANIMAL += PRINT_ANIMAL + "\n";
        }
        int choice = InteractionUtils.askForInt("\nChoisissez un animal : \n" + PRINT_ALL_ANIMAL
                , 1, 4);
        return choice;
    }

    private void trainChoice(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nChoisissez ce que vous voulez faire : " +
                "\n1 : choisissez de dormir\n2 : choisissez d'aller à la rencontre des autres passagers", 1, 2);
        if (choice == 1) {
            String SLEEP_TIME = "\nVous vous couchez dans votre cabine et dormez jusqu'à ce que le train freine brutalement et qu'une voix vous annonce que vous êtes arrivé.";
            ScrollingInWindow.printInWindow(SLEEP_TIME, 0);
        }
        if (choice == 2) {
            String FRIENDS_TIME = "\nVous vous rendez à la cabine voisine où vous apercevez deux jeunes plus ou moins de votre âge. Vous décidez de toquer, vous entrez et entamez une discussion. \nVous faites la connaissance de " + ConsoleColors.RED + "Eloise Midgen " + ConsoleColors.RESET + "& " + ConsoleColors.RED + "Vincent Crabbe" + ConsoleColors.RESET + " tous deux en première année comme vous. Après plusieurs heures de discussion celle-ci s'interrompt \npour laisser place au bruit du train qui freine brutalement et à une voix qui vous annonce que vous êtes arrivé.\n";
            wizard.addFriend(new Friend("Eloise Midgen", null));
            wizard.addFriend(new Friend("Vincent Crabbe", null));
            ScrollingInWindow.printInWindow(FRIENDS_TIME, 0);

        }

    }
}



