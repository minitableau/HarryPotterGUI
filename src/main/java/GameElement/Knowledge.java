package GameElement;

public class Knowledge {
    private String name;

    public Knowledge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Knowledge quidditch = new Knowledge("Quidditch");
    public static Knowledge fluffy = new Knowledge("Fluffy - Le Chien à trois têtes");
    public static Knowledge fluffySleep = new Knowledge("Musique endort Fluffy - Le Chien à trois têtes");
    public static Knowledge philosopherStone = new Knowledge("La pierre philosophale");
    public static Knowledge mandragores = new Knowledge("Mandragores");
    public static Knowledge veraVerto = new Knowledge("Vera Verto");
    public static Knowledge gryffindorSword = new Knowledge("Gryffindor Sword");

}
