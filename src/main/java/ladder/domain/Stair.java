package ladder.domain;

public class Stair {
    private final boolean stair;

    public Stair() {
        this(false);
    }

    public Stair(final boolean stair) {
        this.stair = stair;
    }

    public Stair first() {
        return new Stair(false);
    }

    public boolean isExist() {
        return stair;
    }

    public boolean getStair() {
        return stair;
    }
}
