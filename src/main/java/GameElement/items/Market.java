package GameElement.items;

import GameElement.characters.Wizard;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

public class Market {

    public static Potion[] potions = new Potion[]{
            new HealPotion(),
            new DamagePotion(),
            new AccuracyPotion(),
            new ResistancePotion()
    };
    private static String potionString;

    public static void market(Wizard wizard) {
        ScrollingInWindow.printInWindow("\n\tVous arrivez dans un magasin de potion.");

        while (true) {
            int money = wizard.getMoney();

            potionString = "";
            for (int i = 0; i < potions.length; i++) {
                potionString += "\n" + (i + 1) + " : " + potions[i];

            }

            int choice = InteractionUtils.askForInt("\nVous disposez de " + money + " mornilles." + "\nVoici les potions disponibles à l'achat :" +
                    potionString + "\n" + (potions.length + 1) + " : Quitter le magasin.", 1, potions.length + 1);


            if (choice == potions.length + 1) {
                break;
            }

            Potion potion = potions[choice - 1];

            if (money >= potion.getCost()) {
                wizard.getBackpack().addPotion(potion);
                wizard.setMoney(money - potion.getCost());
                ScrollingInWindow.printInWindow("Vous avez acheté une " + potion.getName() + " !");
            } else {
                ScrollingInWindow.printInWindow("Vous n'avez pas assez d'argent pour acheter cette potion.");
            }
        }
    }
}
