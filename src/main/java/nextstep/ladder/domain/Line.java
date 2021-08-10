package nextstep.ladder.domain;

public enum Line {
    INIT_LINE(false),
    NONE_LINE(false),
    IS_LINE(true);

    private final boolean isExist;

    Line(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return isExist;
    }
}
