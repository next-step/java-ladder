package nextstep.ladder.domain;

public enum Line {
    INITLINE(false),
    NONELINE(false),
    ISLINE(true);

    private final boolean isExist;

    Line(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return isExist;
    }
}
