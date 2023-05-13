package Level;

import GameElement.Knowledge;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Basilic;
import GameElement.items.Item;
import GameElement.items.Market;
import GameElement.spells.Accio;
import GameElement.spells.Immobulus;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.ScrollingInWindow;
import utils.ScrollingText;

import static utils.ScrollingInWindow.nextButton;

public class Level2 extends AbstractLevel {

    public static boolean tooth = false;
    private Basilic enemy;

    @Override
    public void startLevel(Wizard wizard) {
        String Potions = "Avant vous souhaitez faire le plein de fourniture pour cela vous utilisez une cheminée qui permet de transplaner, vous prononcez votre destination : \"chemin de traverse\". \nEt vous arrivez dans un petit magasin de potions :";
        ScrollingInWindow.printInWindow(Potions);
        nextButton.setOnAction(event34 -> {
            Market.market(wizard);
            nextButton.setOnAction(event35 -> {
                String WarningElfDobby = "\nAvant de partir vous rencontrez un elfe de maison nommée Dobby qui vous met en garde qu'il ne faut pas retourner à Poudlard cette année, car un complot se prépare. \nVous ne prêtez pas attention, puisque c'est là-bas que vous êtes heureux. Vous sortez de la boutique pour vous rendre à la gare de Londres, mais vous ratez \nle train à cause de ce petit elfe qui vous a retardé chez le marchant de potion. Vous devez donc vous rendre à Poudlard par un autre moyen.";
                ScrollingInWindow.printInWindow(WarningElfDobby);
                nextButton.setOnAction(event36 -> {
                    String Steal = "Vous savez qu'il existe une voiture volante appartenant au parent de Fleur ainsi vous allez chez fleur et emprunter pour une durée indéterminée cette fameuse voiture.";
                    ScrollingInWindow.printInWindow(Steal);
                    nextButton.setOnAction(event37 -> {
                        String FirstClass = "Après plusieurs heures de voyage. Vous arrivez enfin à Poudlard, il est déjà l'heure de votre premier cours, il s'agit d'un cours de botanique avec le professeur Chourave.";
                        ScrollingInWindow.printInWindow(FirstClass);
                        nextButton.setOnAction(event38 -> {
                            skipSchool(wizard);
                            nextButton.setOnAction(event39 -> {
                                String AccioLearning = "Vous assistez ensuite au cours de \"Défense contre les forces du mal\" où vous rencontrez le professeur Gilderoy Lockhart. Au cours de la séance, \nil libère des lutins de Cornouailles dans la classe pour observer comment vous vous débrouillez. Grâce à votre amie Fleur, qui a continué à pratiquer durant les vacances, \nvous apprenez le sortilège Immobulus qui permet de ralentir le temps et de les attraper. Vous réalisez également qu'apprendre le sort Accio pourrait être utile pour \nrécupérer des objets à distance. Vous profitez de l'exercice pour pratiquer le sort Accio.";
                                ScrollingInWindow.printInWindow(AccioLearning);
                                wizard.addSpell(new Accio());
                                wizard.addSpell(new Immobulus());

//            if (!wizard.getKnowledges().contains(Knowledge.quidditch)) {
//                joinQuidditch(wizard);
//            }

                                nextButton.setOnAction(event40 -> {
                                    String SecretRoom = "En vous promenant dans le couloir vous entendez une voix étrange provenant du mur. Peu de temps apres d'autre étudiant arrive, mais eux n'entende rien. \nLa voix provenant du mur s'arrête et vous écoutez la discussion des élèves a coté de vous. Ils font circuler la rumeurs qu'une certaine chambre des Secrets aurait été ouverte, \ndans laquelle se situerai un monstre. Cependant, vous n'y croyait pas et retourner a vos occupation en vous questionnant sur la voix provenant du mur.";
                                    ScrollingInWindow.printInWindow(SecretRoom);
                                    nextButton.setOnAction(event41 -> {
                                        metamorphosisOrLibrary(wizard);
                                        nextButton.setOnAction(event42 -> {
                                            String ConvocationAtDumbledore = "Vous vous dirigez à nouveau vers votre dortoir et trouvez le chat de M. Rusard pétrifié à coté d'une élève elle aussi pétrifié. M. Rusard arrive quelques secondes après \net vous accuse d'avoir pétrifié son chat et cette élève. Vous êtes donc convoqué chez M. Dumbledore. Vous arrivez dans son bureau, et apercevais sur une étagère \nle choixpeau magique qui vous parle de votre maison. Et vous demande si vous êtes satisfait.";
                                            ScrollingInWindow.printInWindow(ConvocationAtDumbledore);
                                            nextButton.setOnAction(event43 -> {
                                                goodHouse(wizard);
                                                nextButton.setOnAction(event44 -> {
                                                    String FindSword = "Vous trouvez aussi sous celle-ci une magnifique épée";
                                                    ScrollingInWindow.printInWindow(FindSword);
                                                    nextButton.setOnAction(event45 -> {
                                                        stealSword(wizard);
                                                        nextButton.setOnAction(event46 -> {

                                                            String Innocent = "\nDumbledore arrive enfin. Il vous parle, mais ne vous soupçonne pas d'avoir pétrifié ce gens. Il pense que vous n'êtes l'auteur de ces actes. \nIl vous laisse donc partir mais vous demande d'être très prudent.";
                                                            ScrollingInWindow.printInWindow(Innocent);
                                                            nextButton.setOnAction(event47 -> {
                                                                String TomJournal = "Vous trouvez en sortant sur une commode un journal intitulé \"Journal de Tom Jedusor\". Une fois arrivé dans votre chambre vous l'ouvrer pour le lire, \nmais remarqué qu'il n'y a rien d'écrit dedans. Vous vous posez des questions et essayer d'écrire votre nom. Le journal efface instantanément ce que vous avez écrit et \nvous répond : Bonjour, " + wizard.getName() + ". Vous essayez de confirmer les bruits de couloir sur la chambre des secrets et demandez au journal où se situe celle-ci. \nCelui-ci vous répond qu'elle est située dans les toilettes des filles au deuxième étage celle qui sont abandonnées, il vous précise que pour l'ouvrir il faudra faire preuve \nd'observation et parlé une langue que très peu maitrise : le fourchelangue. Vous décidez de vous rendre dans ces toilettes et essayer de trouver l'entrée de \ncette chambre des secrets. Mais soudain, la voix qui venait du mur se remet à parler. En lui répondant, cela ouvre un passage, dans lequel vous pénétrez. \nVous arrivez alors dans une salle gigantesque avec plein de statue de serpent sur les côtés. Vous comprenez que la voie que vous entendiez à travers les murs \nétait du fourche langue et donc que vous aviez le don qui permettait d'ouvrir le passage des toilettes.";
                                                                ScrollingInWindow.printInWindow(TomJournal);
                                                                nextButton.setOnAction(event48 -> {
                                                                    String BasilicFight = "Après quelque minutes passé seul dans cette grande salle un énorme Basilic apparait vous engagez alors le combat.";
                                                                    ScrollingInWindow.printInWindow(BasilicFight);
                                                                    nextButton.setOnAction(event49 -> {
                                                                        //TODO petre close la stage
                                                                        StartController.enemy = new Basilic();
                                                                        FightBoard fightBoard = new FightBoard();
                                                                        fightBoard.creationFenetreJeu(fightBoard);
                                                                        fightBoard.setGame();
                                                                        if (!wizard.isAlive()) return;
                                                                        nextButton.setOnAction(event50 -> {
                                                                            String Escape = "\nVous sortez de la chambre des secrets, très fiers de vous car vous avez réussi à vaincre le basilic. Vous retournez à votre chambre détruire le journal que \nvous avez trouvez car vous vous rendez compte du pouvoir potentiellement dangereux qu'il possède. \nVous vous endormez et rêvez de votre deuxième année à Poudlard. Pour finir, cette année un grand match de Quidditch est organisé.";
                                                                            ScrollingInWindow.printInWindow(Escape);
//                                                                            nextButton.setOnAction(event51 -> {
//                                                                                Level1.simulateQuidditchMatch(wizard);
                                                                                nextButton.setOnAction(event52 -> {
                                                                                    String AnnonceWinnerHouse = "Par la suite, vous vous rendez dans la grande salle pour le repas de fin d'année. Dumbledore annonce que la maison gagnante cette année est la maison ";
                                                                                    ScrollingInWindow.printInWindow(AnnonceWinnerHouse);
                                                                                    nextButton.setOnAction(event53 -> {
                                                                                        Level1.winnerHouse(wizard);
                                                                                        nextButton.setOnAction(event54 -> {
                                                                                            String GO_MARKET = "\nVous passez brillamment votre deuxième année et rentrer chez vous durant les vacances." + ConsoleColors.ITALIC + "\n\tPlusieurs semaines s'écoulent, voilà déjà la rentrée arriver." + ConsoleColors.RESET;
                                                                                            ScrollingInWindow.printInWindow(GO_MARKET);
                                                                                            nextButton.setOnAction(event55 -> {
                                                                                                if (!wizard.isAlive()) return;
                                                                                                new Level3().startLevel(wizard);
                                                                                            });
//                                                                                        });
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
        });
    }

    private void skipSchool(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nChoisissez ce que vous voulez faire : " +
                "\n1 : Vous vous rendez au cours de Mme Chourave.\n2 : Vous séchez le cours pour vous entrainer avec les sorts que vous connaissez deja.", 1, 2);

        if (choice == 1) {
            String Choice1 = "\nVous apprenez qu'il existe des plantes nommé mandragores qui permettent de guérir les gens si par malheur il se font pétrifier.";
            ScrollingInWindow.printInWindow(Choice1, 0);
            wizard.addKnowledge(Knowledge.mandragores);

        }
        if (choice == 2) {
            String Choice2 = "\nVous séchez le cours de Mme Chourave pour vous entrainer avec les sorts que vous connaissez deja. Vous gagner 2% de dégâts.\n";
            ScrollingInWindow.printInWindow(Choice2, 0);
            wizard.setPowerBonus(wizard.getPowerBonus() + 2);

        }

    }

    private void joinQuidditch(Wizard wizard) {
        String Invitation = "A la fin du cours, un groupe d'élèves vous approche pour vous inviter à rejoindre l'équipe de Quidditch.";
        ScrollingText.printWithDelay(Invitation, 0);
        String Question = ConsoleColors.BLUE + "\nSouhaitez vous rejoindre l'équipe de quidditch  : " + ConsoleColors.RESET;
        ScrollingText.printWithDelay(Question, 0);
        String Choice = "1 : Oui.\n2 : Non.";
        ScrollingText.printWithDelay(Choice, 0);

        int choice = InteractionUtils.askForInt(1, 2);

        if (choice == 1) {
            String Choice1 = "\nVous rejoignez l'équipe quidditch !";
            ScrollingText.printWithDelay(Choice1, 0);
            wizard.addKnowledge(Knowledge.quidditch);

        }
        if (choice == 2) {
            String Choice2 = "\nVous ne rejoignez pas l'équipe quidditch.\n";
            ScrollingText.printWithDelay(Choice2, 0);

        }

    }


    private void metamorphosisOrLibrary(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nChoisissez ce que vous voulez faire : " +
                "\n1 : Vous allez au cours de metamorphose de McGonagall.\n2 : Séchez les cours pour aller à la bibliothèque en apprendre plus sur la chambre de secret.", 1, 2);


        if (choice == 1) {
            String Choice1 = "\nVous allez en cours de metamorphose, donnez par le professeur McGonagall, où vous apprenez à transformer votre animal de compagnie en verre à vin avec le sort Vera verto.";
            ScrollingInWindow.printInWindow(Choice1, 0);
            wizard.addKnowledge(Knowledge.veraVerto);
        }
        if (choice == 2) {
            String Choice2 = "\nVous séchez les cours pour aller à la bibliothèque en apprendre plus sur la chambre de secret. Vous apprenez l'existence d'un basilic qui tue si on le regarde \nmais pouvant être tué en un coup par une épée à condition d'etre membre de la maison Gryffondor.";
            ScrollingInWindow.printInWindow(Choice2, 0);
            wizard.addKnowledge(Knowledge.gryffindorSword);

        }
    }

    private void goodHouse(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nÊtes-vous satisfait de votre maison : " +
                "\n1 : Oui.\n2 : Non.", 1, 2);

        if (choice == 1) {
            String Choice1 = "\nC'est normal je ne me trompe jamais ! Pour votre fidélité à votre maison je vous offre 10 points de maison.\n";
            ScrollingInWindow.printInWindow(Choice1, 0);
            wizard.setHousePoints(wizard.getHousePoints() + 10);
        }
        if (choice == 2) {
            String Choice2 = "\nVotre cas ne fut pas simple à traiter mais vous verrez, vous comprendrez mon choix.\n";
            ScrollingInWindow.printInWindow(Choice2, 0);

        }

    }

    private void stealSword(Wizard wizard) {
        int choice = InteractionUtils.askForInt("\nChoisissez ce que vous voulez faire : " +
                "\n1 : Voler l'épée.\n2 : Attendre l'arrivé de Dumbledore.", 1, 2);

        if (choice == 1) {
            String Choice1 = "\nVous volez l'épée et la mettez dans votre sac.";
            ScrollingInWindow.printInWindow(Choice1, 0);
            wizard.getBackpack().addItem(Item.gryffindorSword);
        }
        if (choice == 2) {
            String Choice2 = "\nVous patientez quelques minutes.\n";
            ScrollingInWindow.printInWindow(Choice2, 0);

        }

    }
}