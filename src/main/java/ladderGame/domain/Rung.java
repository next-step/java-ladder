package ladderGame.domain;

public class Rung {

    private Boolean isRung;

    private Rung(boolean rung) {
        this.isRung = rung;
    }

    public static Rung of(boolean isRung) {
        return new Rung(isRung);
    }

    public boolean value() {
        return isRung;
    }

    public boolean isEmpty() {
        return !isRung;
    }
}
