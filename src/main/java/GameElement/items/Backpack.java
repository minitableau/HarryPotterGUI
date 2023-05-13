package GameElement.items;

import GameElement.House;
import GameElement.Knowledge;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.AbstractEnemy;
import GameElement.characters.enemies.Basilic;
import GameElement.characters.enemies.DoloresOmbrage;
import com.example.harrypottergui.vue.CharacterRepresentation;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import javafx.animation.Timeline;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final Wizard wizard;

    private final ArrayList<Potion> potions = new ArrayList<>();

    private final ArrayList<Item> items = new ArrayList<>();
    private String potionString;
    private String itemString;

    public Backpack(Wizard wizard) {
        this.wizard = wizard;
    }

    public boolean open(AbstractEnemy enemy) {
        boolean comeback2 = true;
        while (comeback2) {
            int choice = InteractionUtils.askForInt("\nVous ouvrez votre sac, souhaitez-vous prendre quelque chose ?" +
                    "\n1 : Chercher une potion\n2 : Chercher un objet\n3 : Refermer le sac", 1, 3);
            switch (choice) {
                case 1 -> {
                    comeback2 = findPotions();
                }
                case 2 -> {
                    comeback2 = findItems(enemy);
                }
                case 3 -> {
                    return true;
                }
            }

        }
        return false;
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public void removePotion(Potion potion) {
        potions.remove(potion);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    private boolean findPotions() {
        int numPotions = potions.size();
        if (numPotions == 0) {
            ScrollingInWindow.setMessage("Vous n'avez aucune potion disponible.");
            return true;
        } else {
            potionString = "";
            for (int i = 0; i < numPotions; i++) {
                potionString += "\n" + (i + 1) + " : " + potions.get(i).getName();
            }
            int choice = InteractionUtils.askForInt("\nVeuillez choisir une potion :" +
                    potionString + "\n" + (numPotions + 1) + " : Retourner dans le sac", 1, numPotions + 1);

            if (choice == numPotions + 1) {
                return true;
            }
            Potion chosenPotion = potions.get(choice - 1);
            ScrollingInWindow.setMessage("Vous avez choisi la " + chosenPotion.getName() + ".");
            chosenPotion.use(wizard);
            potions.remove(choice - 1);
        }
        return false;
    }


    private boolean findItems(AbstractEnemy enemy) {
        int numItems = items.size();
        if (numItems == 0) {
            ScrollingInWindow.setMessage("Vous n'avez aucun objet disponible.");
            return true;
        } else {

            itemString = "";
            for (int i = 0; i < numItems; i++) {
                itemString += "\n" + (i + 1) + " : " + items.get(i).getName();
            }


            int choice = InteractionUtils.askForInt("\nVeuillez choisir un objet :" +
                    itemString + "\n" + (numItems + 1) + " : Retourner dans le sac", 1, numItems + 1);

            if (choice == numItems + 1) {
                return true;
            }
            Item chosenItem = items.get(choice - 1);
            ScrollingInWindow.setMessage("Vous avez choisi " + chosenItem.getName() + ".");

            if (chosenItem == Item.gryffindorSword && enemy instanceof Basilic) {
                if (wizard.getKnowledges().contains(Knowledge.gryffindorSword)) {
                    if (enemy.getDistance() != 1) {
                        ScrollingInWindow.setMessage("Vous frappez dans le vide avec votre épée car vous êtes trop loin.");
                    } else {
                        if (wizard.getHouse() == House.GRYFFINDOR) {
                            ScrollingInWindow.setMessage("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci transperse le basilic et le tue.");
                            enemy.die();
                            Timeline task = FightBoard.setBarEnemy((StartController.enemy), ((CharacterRepresentation) FightBoard.HBenemy.getChildren().get(0)).getBarreDeVie());
                            task.playFromStart();
                        } else {
                            ScrollingInWindow.setMessage("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci se brise au contact du basilic.");
                            items.remove(choice - 1);
                        }
                    }

                } else {
                    ScrollingInWindow.setMessage("Vous ne savez pas comment utiliser cette épée et quel et son pouvoir, vous auriez du lire plus de livre.");
                }

            } else if (chosenItem == Item.firework && enemy instanceof DoloresOmbrage) {
                items.remove(choice - 1);
                ScrollingInWindow.setMessage("Vous allumer un feu d'artifice en direction de Dolores Ombrage, il explose sur elle ce qui lui enlève 50 points de vie.");
                enemy.setLifePoint(enemy.getLifePoint() - 50 - (50 * wizard.getPowerBonus()) / 100);
                if (enemy.isAlive()) {
                    ScrollingInWindow.setMessage("L'allumage du feu d'artifice vous à propulser vous êtes désormais à 4 mètres de Dolores Ombrage.");
                    enemy.setDistance(4);
                }

            } else {
                ScrollingInWindow.setMessage("L'objet que vous utilisez n'a aucune effet sur ce combat.");
            }

        }
        return false;
    }
}
