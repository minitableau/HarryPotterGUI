package Level;

import GameElement.characters.Wizard;
import GameElement.characters.enemies.Dementor;
import GameElement.characters.enemies.Enemy;
import GameElement.items.Market;
import GameElement.spells.ExpectoPatronum;
import utils.ScrollingText;

public class Level3 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        String MARKET_LVL3 = "Comme avant chaque rentrée vous décidez de passer au magasin de potion";
        ScrollingText.printWithDelay(MARKET_LVL3);
        Market.market(wizard);

        String INTRO_LVL3 = "Vous êtes de retour à Poudlard, et vous vous rendez à la Grande Salle pour une réunion d'urgence. Le professeur Dumbledore vous informe que les Détraqueurs se sont échappés \nde la prison d'Azkaban et qu'ils errent maintenant librement dans les rues et les campagnes, aspirant l'espoir et le bonheur de quiconque croise leur chemin. \nCependant, il y a un sort qui peut les mettre en fuite : Expecto Patronum. Dumbledore vous demande de vous entraîner à ce sort et de vous préparer à affronter les Détraqueurs.";
        ScrollingText.printWithDelay(INTRO_LVL3);

        String PatronusLearn = "Vous assistez au cours de Sortilèges donné par le professeur Lupin. Il vous apprend les bases de la fabrication d'un Patronus, et vous explique comment le lancer correctement. \nPour qu'il effraie un détraqueur il faut être à 5 mètres ou moins. Vous vous entraînez ensuite avec vos camarades de classe.";
        ScrollingText.printWithDelay(PatronusLearn);
        wizard.addSpell(new ExpectoPatronum());

        String TrainPatronus = "Vous pratiquez pendant plusieurs mois votre sortilège sur des cibles volantes qui ressemblent aux Détraqueurs, tout en évitant les obstacles sur le terrain de Quidditch. \nVous devez faire preuve de précision et de rapidité pour vaincre vos ennemis.";
        ScrollingText.printWithDelay(TrainPatronus);

        String ReadyToFight = "Vous vous sentez prêt à affronter les Détraqueurs. Vous vous dirigez vers la forêt interdite pour les combattre.";
        ScrollingText.printWithDelay(ReadyToFight);

        Enemy enemy = new Dementor();
        wizard.fight(enemy);
        if(!wizard.isAlive())return;

        String YouWin = "Vous retournez à Poudlard en triomphant, avec le sentiment d'avoir accompli une grande mission. Vous êtes félicité par Dumbledore et vos camarades de classe pour avoir sauvé \nPoudlard des Détraqueurs, mais votre maison à pris des risques inconsidérés et sera donc éliminé de la liste des maisons pouvant être récompensé cette année. \nMais peut importe, vous vous sentez fier d'avoir appris à maîtriser un sort aussi puissant. Vous partez en vacance sereinement et très fier d'avoir réussi votre troisième année.\n";
        ScrollingText.printWithDelay(YouWin);

    }
}



