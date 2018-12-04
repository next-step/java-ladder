package game.ladder.domain;

public enum  Probablity {

    HIGH(20), MIDDLE(30), LOW(50);

    private static final int MAXIMUM = 100;

    private int rate;

    Probablity(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

}
