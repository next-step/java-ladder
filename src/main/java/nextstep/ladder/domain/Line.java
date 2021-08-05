package nextstep.ladder.domain;

public enum Line {
    INITLINE(false, "    |"),
    NONELINE(false, "     |"),
    ISLINE(true, "-----|");

    private final boolean isExist;
    private final String line;

    Line(boolean isExist, String line) {
        this.isExist = isExist;
        this.line = line;
    }

    public boolean isExist() {
        return isExist;
    }

    public String getLine() {
        return line;
    }
}
