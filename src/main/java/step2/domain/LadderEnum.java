package step2.domain;

public enum LadderEnum {
    HEIGHT(1),
    LINE(2),
    BLANK(3);

    private int type;

    LadderEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
