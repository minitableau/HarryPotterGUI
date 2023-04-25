package Level;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.Enemy;
import GameElement.characters.enemies.PeterPettigrew;
import utils.ScrollingText;

public class Level4 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        String StartYear = "Plusieurs semaines s'écoulent, voilà déjà la rentrée arriver. Vous vous dirigez vers Poudlard pour une nouvelle année scolaire. Vous vous rendez au magasin de potion \npour acheter des potions et vos nouvelles fournitures scolaire.";
        ScrollingText.printWithDelay(StartYear);

        String IntroLvl4 = "En début d'année, vous vous inscrivez pour participer au plus grand tournoi de sorcier du monde magique sans trop vous renseignez, vous savez juste que c'est un honneur \nd'être tiré au sort et que si c'est le cas vous rencontrerez de très grand sorcier. L'année file et voila je jour du tirage. Vous vous retrouvez être un des gagnants du \ntirage au sort pour le Tournoi des Trois Sorciers, mais votre victoire s'est avérée être une malédiction. En effet, lors d'une des épreuves vous \ntombez nez à nez face à Voldemort et Peter Pettigrew dans un cimetière sombre et lugubre. Vous comprenez que cela n'était pas du tout prévu dans le tournoi. \nVous vous savez pas assez puissant pour vaincre Voldemort et Peter Pettigrew sachant que vous êtes seul et connaissez pas beaucoup de sort. Vous devez trouver un moyen de \nvous échapper rapidement. Vous apercevez un objet brillant au loin, qui pourrait être le portolion dont vous avez besoin d'atteindre pour vous échapper. \nVous vous dites que si vous arrivez à leur échapper ca sera comme si vous aviez réussi à les vaincre du moins comme si vous aviez vaincu Peter Pettigrew.";
        ScrollingText.printWithDelay(IntroLvl4);

        Enemy enemy = new PeterPettigrew();
        wizard.fight(enemy);
        if(!wizard.isAlive())return;

        String SuccessfulEscape = "Vous essayer de comprendre ou le portolion vous à fait attérir. Vous vous retrouvez dans Poudlard, en sécurité. Vous avez réussi à échapper à Voldemort, mais vous savez que \nvous n'en avez pas fini avec lui. Vous terminé votre année brillamment car vous savez que vous devez vous préparer pour l'ultime bataille qui aura lieu bientôt. \nCette année pas de vacance, vous décidez de travailler à Poudlard pour gagnez un peu d'argent (50 mornilles) et pouvoir travailler sur vos sorts.";
        ScrollingText.printWithDelay(SuccessfulEscape);
        wizard.setMoney(wizard.getMoney() + 50);
    }

}


