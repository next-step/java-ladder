package ladderGame.domain;

public class Rung {

    private Boolean rung;

    public Rung(boolean rung) {
        this.rung = rung;
    }

    public static Rung newDrawLine() {
        return new Rung(true);
    }

    public static Rung newEmptyLine() {
        return new Rung(false);
    }

    public boolean value() {
        return rung;
    }

    public boolean isEmpty() {
        return !rung;
    }
}
