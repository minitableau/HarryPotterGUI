package GameElement.characters;


import GameElement.*;
import GameElement.characters.enemies.AbstractEnemy;
import GameElement.items.Backpack;
import GameElement.spells.AbstractSpell;
import Level.Level2;
import MiniGame.ThirteenStick.ThirteenStick;
import com.example.harrypottergui.vue.CharacterRepresentation;
import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import javafx.animation.Timeline;
import utils.InteractionUtils;
import utils.ScrollingInWindow;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {

    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private final Backpack backpack;
    private int housePoints = 200;
    private final ArrayList<Knowledge> knowledges = new ArrayList<>();
    private final ArrayList<AbstractSpell> knownSpells = new ArrayList<>();
    private final ArrayList<Friend> friends = new ArrayList<>();
    private int accuracyBonus;
    private int powerBonus;
    private int efficiencyPotionsBonus;
    private int resistanceBonus;
    private int mana;
    private int money = 100;
    private String spellstring;

    public Wizard(String name, Pet pet, Wand wand, House house) {
        super(name);
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;

        this.backpack = new Backpack(this);
    }

    @Override
    public void attack(Character character) {
        if (!(character instanceof AbstractEnemy enemy)) {
            return;
        }

//        System.out.println("\n" + this);
//        System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que " + enemy.getName() + " se situe à " + enemy.getDistance() + " mètres et à " + enemy.getLifePoint() + " points de vie ?" + ConsoleColors.RESET);
//        System.out.println("1 : " + enemy.whatAWizardCanDoAgainstMe());
//        System.out.println("2 : Se rapprocher");
//        System.out.println("3 : Utiliser un sort");
//        System.out.println("4 : Ouvrir votre sac");
//
//        int choice = InteractionUtils.askForInt(1, 4);

        int choice = InteractionUtils.askForInt("\nQue voulez-vous faire sachant que " + enemy.getName() + " se situe à " + enemy.getDistance() + " mètres et à " + enemy.getLifePoint() + " points de vie ?" +
                "\n1 : " + enemy.whatAWizardCanDoAgainstMe() + "\n2 : Se rapprocher\n3 : Utiliser un sort\n4 : Ouvrir votre sac", 1, 4);

        while (true) {
            if (choice == 1) {
                enemy.onWizardAttack(this);
                break;
            } else if (choice == 2) {
                ScrollingInWindow.setMessage("Vous vous rapprochez du " + enemy.getName() + ".");
                enemy.setDistance(enemy.getDistance() - 1);
                enemy.onWizardBackpackOpen(this);
                break;
            } else if (choice == 3) {
                AbstractSpell spell = this.selectSpell();
                if (spell != null) {
                    spell.cast(this, enemy);
                    enemy.onWizardBackpackOpen(this);
                } else {
                    attack(character);
                }
                break;
            } else if (choice == 4) {
                boolean shouldBreak = this.getBackpack().open(enemy);
                if (shouldBreak) {
                    attack(character);
                }
                break;

            }
        }
    }


    public void fight(AbstractEnemy enemy) {
        while (enemy.getDistance() >= 1 && enemy.isAlive() && this.isAlive()) {
            attack(enemy);
            if (enemy.getDistance() < 1) {
                break;
            }
            if (!enemy.isAlive()) {
                FightBoard.gameStage.close();
                break;
            }
            List<Friend> sameHomeWizardFriends = enemy.whichFriendsCanTheWizardHave(this);
            for (Friend sameHomeWizardFriend : sameHomeWizardFriends) {
                ScrollingInWindow.setMessage("\nVotre ami " + sameHomeWizardFriend.getName() + " peut aussi attaquer le " + enemy.getName() + ".");
                attack(enemy);
                if (enemy.getDistance() < 1 || !enemy.isAlive()) {
                    FightBoard.gameStage.close();
                    break;
                }
            }
            if (enemy.getDistance() < 1 || !enemy.isAlive()) {
                FightBoard.gameStage.close();
                break;
            }

            enemy.attack(this);
        }

        if (enemy.getDistance() < 1) {
            this.die();
            Timeline task = FightBoard.setBarWizard((StartController.wizard), ((CharacterRepresentation) FightBoard.HBhero.getChildren().get(0)).getBarreDeVie());
            task.playFromStart();
            if (enemy.getType().equals("Humain")) {
                ScrollingInWindow.setMessage("Quel idée de se coller à " + enemy.getName() + " ! Celui-ci vous attrape et vous tue.");
                FightBoard.gameStage.close();
                ScrollingInWindow.stagetext.close();
            } else {
                ScrollingInWindow.setMessage("Quel idée de se coller au " + enemy.getName() + " ! Celui-ci vous mange.");
                FightBoard.gameStage.close();
                ScrollingInWindow.stagetext.close();
            }
        }

        if (!enemy.isAlive()) {
            if (enemy.getType().equals("Humain")) {
                ScrollingInWindow.setMessage("Vous avez vaincu " + enemy.getName() + " !");
                FightBoard.gameStage.close();
            } else {
                ScrollingInWindow.setMessage("Vous avez vaincu " + enemy.getName() + " !");
                Level2.tooth = false;
                FightBoard.gameStage.close();
            }
        }
    }

    public boolean defend(Wizard wizard) {
        return ThirteenStick.thirteenStick();
    }

    private AbstractSpell selectSpell() {
        int numSpells = this.getKnownSpells().size();

        AbstractSpell spell = null;
        if (numSpells == 0) {
            ScrollingInWindow.setMessage("Vous n'avez appris aucun sort.");
        } else {
            spellstring = "";
            for (int i = 0; i < numSpells; i++) {
                spellstring += "\n" + (i + 1) + " : " + this.getKnownSpells().get(i).getName();
            }


            int choice = InteractionUtils.askForInt("\nVeuillez choisir un sort :" +
                    spellstring + "\n" + (numSpells + 1) + " : Ne pas utiliser de sort.", 1, numSpells + 1);
            if (choice < numSpells + 1) {
                spell = this.getKnownSpells().get(choice - 1);
                ScrollingInWindow.setMessage("Vous avez choisi le sort " + spell.getName() + ".");
            } else {
                ScrollingInWindow.setMessage("Vous avez choisi de ne pas utiliser de sort.");
            }
        }

        return spell;
    }

    @Override
    public String toString() {
        return "Statistiques de " + name + " : " + "❤️ " + getLifePoint() + "/" + getMaxLifePoint() + " |" + " 💧 " + mana + "/100 |" + " 🛡️ + " + resistanceBonus + "% |" + " 💪 + " + powerBonus + "% |" + " 🎯 + " + accuracyBonus + "% |" + " ⚗️ + " + efficiencyPotionsBonus + "% |" + " 💵 " + money + "$";
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<AbstractSpell> getKnownSpells() {
        return knownSpells;
    }

    public boolean hasKnownSpell(String name) {
        return knownSpells.stream().anyMatch(spell -> spell.getName().equalsIgnoreCase(name));
    }

    public void addSpell(AbstractSpell spell) {
        this.knownSpells.add(spell);
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public List<Friend> getFriendsSameHome() {
        return getFriendsSameHome(new ArrayList<String>());
    }

    public List<Friend> getFriendsSameHome(List<String> excludesNames) {
        List<Friend> friendsSameHome = new ArrayList<>();
        for (Friend friend : friends) {
            if (friend.getHouse() == house && !excludesNames.contains(friend.getName())) {
                friendsSameHome.add(friend);
            }
        }
        return friendsSameHome;
    }

    public void addFriend(Friend friend) {
        this.friends.add(friend);
    }

    public int getHousePoints() {
        return housePoints;
    }

    public void setHousePoints(int housePoints) {
        this.housePoints = housePoints;
    }

    public List<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void addKnowledge(Knowledge knowledge) {
        this.knowledges.add(knowledge);
    }

    public Backpack getBackpack() {
        return backpack;
    }


    public int getPowerBonus() {
        return powerBonus;
    }

    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
    }

    public int getAccuracyBonus() {
        return accuracyBonus;
    }

    public void setAccuracyBonus(int accuracyBonus) {
        this.accuracyBonus = accuracyBonus;
    }

    public int getEfficiencyPotionsBonus() {
        return efficiencyPotionsBonus;
    }

    public void setEfficiencyPotionsBonus(int efficiencyPotionsBonus) {
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
    }

    public int getResistanceBonus() {
        return resistanceBonus;
    }

    public void setResistanceBonus(int resistanceBonus) {
        this.resistanceBonus = resistanceBonus;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}


