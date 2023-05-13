package Level;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.DoloresOmbrage;
import GameElement.items.Market;
import GameElement.spells.FeuxfousFuseboum;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import utils.ScrollingInWindow;

import static utils.ScrollingInWindow.nextButton;

public class Level5 extends AbstractLevel {
    public static boolean firework = false;

    @Override
    public void startLevel(Wizard wizard) {
        String GoMarket = "La rentrée arrive à grand pas et juste avant celle-ci vous décidez d'aller faire le plein de potion au magasin.";
        ScrollingInWindow.printInWindow(GoMarket);
        nextButton.setOnAction(event56 -> {
            Market.market(wizard);
            nextButton.setOnAction(event68 -> {
                String IntroLvl5 = "Vous retournez a Poudlard et vous remarquez que Dolores Ombrage est la nouvelle directrice de l'école. Vous appréciez particulièrement Dumbledore et vous êtes triste de le voir partir. \nVous devez faire avec, l'année commence par un cours assez différent de ce que vous connaissiez, vous comprenez que la nouvelle directrice à changer le programme d'apprentissage. \nEn effet, vous n'apprenez plus des sorts pour vous battre mais vous apprenez des sorts qui permettent de générer des feux d'artifice. Il s'agit de FeuxfousFuseboum. \nVous y arrivez plutôt bien mais vous finissez par quittez le cours car vous n'avez pas envie de travailler un sort qui ne vous servira à rien.\nLe grand jour est arrivé, c'est l'heure de passer le Brevet Universel de Sorcellerie Élémentaire (BUSE). Mais Dolores Ombrage, la nouvelle directrice qui ne souhaite pas voir \nles élèves de Poudlard progresser dans le domaine du combat, elle est aigri. Elle veille donc au grain et compte bien se mettre au travers de votre chemin \nsurtout qu'elle n'a pas oublié votre attitude à son premier cours. Vous engagez donc un combat contre elle.";
                ScrollingInWindow.printInWindow(IntroLvl5);
                wizard.addSpell(new FeuxfousFuseboum());
                nextButton.setOnAction(event69 -> {
                    StartController.enemy = new DoloresOmbrage();
//        wizard.fight(enemy);
                    FightBoard fightBoard = new FightBoard();
                    fightBoard.creationFenetreJeu(fightBoard);
                    fightBoard.setGame();
                    if (!wizard.isAlive()) return;
                    nextButton.setOnAction(event70 -> {
                        String SuccessfulEscape = "Les évaluateurs ont vu de quoi vous étiez capable lors de votre combat et decide donc de validé votre BUSE. L'année se termine vous validé une nouvelle année sans trop de difficulté. \nJuste avant de partir en vacance un match de Quidditch a lieu. ";
                        ScrollingInWindow.printInWindow(SuccessfulEscape);
//        Level1.simulateQuidditchMatch(wizard);
                        wizard.setHousePoints(wizard.getHousePoints() + 10);
                        nextButton.setOnAction(event71 -> {
                            String AnnonceWinnerHouse = "Par la suite, vous vous rendez dans la grande salle pour le repas de fin d'année. Ou le professeur Minerva McGonagall annonce que la maison gagnante cette année est la maison ";
                            ScrollingInWindow.printInWindow(AnnonceWinnerHouse);
                            nextButton.setOnAction(event72 -> {
                                Level1.winnerHouse(wizard);
                                nextButton.setOnAction(event73 -> {
                                    String GoNextYear = "Vous prenez des vacances bien mérité. Et êtes fier de vous pour les épreuves traversé cette année.";
                                    ScrollingInWindow.printInWindow(GoNextYear);
                                    nextButton.setOnAction(event74 -> {
                                        if (!wizard.isAlive()) return;
                                        new Level6().startLevel(wizard);
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    }
}









