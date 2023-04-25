package GameElement;

public enum Pet {
    Owl("Chouette"),
    Rat("Rat"),
    Cat("Chat"),
    Toad("Crapaud");

    public final String type;

    Pet(String type) {
        this.type = type;
    }
}
