package GameElement.items;

import GameElement.House;
import GameElement.Knowledge;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.AbstractEnemy;
import GameElement.characters.enemies.Basilic;
import GameElement.characters.enemies.DoloresOmbrage;
import utils.ConsoleColors;
import utils.InteractionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    private final Wizard wizard;

    private final ArrayList<Potion> potions = new ArrayList<>();

    private final ArrayList<Item> items = new ArrayList<>();

    public Backpack(Wizard wizard) {
        this.wizard = wizard;
    }

    public boolean open(AbstractEnemy enemy) {
        boolean comeback2 = true;
        Scanner scanner = new Scanner(System.in);

        while (comeback2) {
            System.out.println(ConsoleColors.BLUE + "\nVous ouvrez votre sac, souhaitez-vous prendre quelque chose ?" + ConsoleColors.RESET);
            System.out.println("1 : Chercher une potion");
            System.out.println("2 : Chercher un objet");
            System.out.println("3 : Refermer le sac");

            int choice = InteractionUtils.askForInt(1, 3);

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
            System.out.println("Vous n'avez aucune potion disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir une potion :" + ConsoleColors.RESET);
            for (int i = 0; i < numPotions; i++) {
                System.out.println((i + 1) + " : " + potions.get(i).getName());
            }
            System.out.println((numPotions + 1) + " : Retourner dans le sac");
            int choice = InteractionUtils.askForInt(1, numPotions + 1);
            if (choice == numPotions + 1) {
                return true;
            }
            Potion chosenPotion = potions.get(choice - 1);
            System.out.println("Vous avez choisi la " + chosenPotion.getName() + ".");
            chosenPotion.use(wizard);
            potions.remove(choice - 1);
        }
        return false;
    }


    private boolean findItems(AbstractEnemy enemy) {
        int numItems = items.size();
        if (numItems == 0) {
            System.out.println("Vous n'avez aucun objet disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un objet :" + ConsoleColors.RESET);
            for (int i = 0; i < numItems; i++) {
                System.out.println((i + 1) + " : " + items.get(i).getName());
            }
            System.out.println((numItems + 1) + " : Retourner dans le sac");
            int choice = InteractionUtils.askForInt(1, numItems + 1);
            if (choice == numItems + 1) {
                return true;
            }
            Item chosenItem = items.get(choice - 1);
            System.out.println("Vous avez choisi " + chosenItem.getName() + ".");

            if (chosenItem == Item.gryffindorSword && enemy instanceof Basilic) {
                if (wizard.getKnowledges().contains(Knowledge.gryffindorSword)) {
                    if (enemy.getDistance() != 1) {
                        System.out.println("Vous frappez dans le vide avec votre épée car vous êtes trop loin.");
                    } else {
                        if (wizard.getHouse() == House.GRYFFINDOR) {
                            System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci transperse le basilic et le tue.");
                            enemy.die();
                        } else {
                            System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci se brise au contact du basilic.");
                            items.remove(choice - 1);
                        }
                    }

                } else {
                    System.out.println("Vous ne savez pas comment utiliser cette épée et quel et son pouvoir, vous auriez du lire plus de livre.");
                }

            } else if (chosenItem == Item.firework && enemy instanceof DoloresOmbrage) {
                items.remove(choice - 1);
                System.out.println("Vous allumer un feu d'artifice en direction de Dolores Ombrage, il explose sur elle ce qui lui enlève 50 points de vie.");
                enemy.setLifePoint(enemy.getLifePoint() - 50 - (50 * wizard.getPowerBonus()) / 100);
                if (enemy.isAlive()) {
                    System.out.println("L'allumage du feu d'artifice vous à propulser vous êtes désormais à 4 mètres de Dolores Ombrage.");
                    enemy.setDistance(4);
                }

            } else {
                System.out.println("L'objet que vous utilisez n'a aucune effet sur ce combat.");
            }

        }
        return false;
    }
}
