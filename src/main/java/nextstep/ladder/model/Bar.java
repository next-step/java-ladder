package nextstep.ladder.model;

public final class Bar {
    private final boolean isActivate;

    public Bar(boolean isActivate) {
        this.isActivate = isActivate;
    }

    public boolean isActivate() {
        return isActivate;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "isActivate=" + isActivate +
                '}';
    }
}
