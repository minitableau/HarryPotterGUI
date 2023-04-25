package GameElement.items;

import GameElement.characters.Wizard;
import utils.ConsoleColors;
import utils.InteractionUtils;

public class Market {

    public static Potion[] potions = new Potion[]{
            new HealPotion(),
            new DamagePotion(),
            new AccuracyPotion(),
            new ResistancePotion()
    };

    public static void market(Wizard wizard) {
        System.out.println(ConsoleColors.ITALIC + "\n\tVous arrivez dans un magasin de potion." + ConsoleColors.RESET);

        while (true) {
            int money = wizard.getMoney();
            System.out.println(ConsoleColors.GREEN + "\nVous disposez de " + money + " mornilles." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Voici les potions disponibles à l'achat :" + ConsoleColors.RESET);


            for (int i = 0; i < potions.length; i++) {
                System.out.println((i + 1) + " : " + potions[i]);
            }

            System.out.println(potions.length + 1 + " : Quitter le magasin.");

            int choice = InteractionUtils.askForInt(1, potions.length + 1);

            if (choice == potions.length + 1) {
                break;
            }

            Potion potion = potions[choice - 1];

            if (money >= potion.getCost()) {
                wizard.getBackpack().addPotion(potion);
                wizard.setMoney(money - potion.getCost());
                System.out.println("Vous avez acheté une " + potion.getName() + " !");
            } else {
                System.out.println("Vous n'avez pas assez d'argent pour acheter cette potion.");
            }
        }
    }
}
