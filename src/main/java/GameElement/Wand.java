package GameElement;

import java.util.Random;


public class Wand {
    private final Core core;
    private final int size;

    public Wand() {
        Random random = new Random();
        this.core = Core.values()[random.nextInt(Core.values().length)];
        this.size = random.nextInt(14) + 22;
    }

    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    public Core getCore() {
        return core;
    }

    public int getSize() {
        return size;
    }
}



