package ladderGame.domain;

public class Rung {

    private Boolean rung;

    public Rung(boolean rung) {
        this.rung = rung;
    }

    public static Rung of(boolean randomBoolean) {
        return new Rung(randomBoolean);
    }

    public boolean value() {
        return rung;
    }

    public boolean isEmpty() {
        return !rung;
    }
}
