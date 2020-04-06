package ladder.domain.ladder;

public enum Bar {
    IS_EXIST(true),
    NOT_EXIST(false);

    private final boolean exist;

    Bar(boolean isExist) {
        this.exist = isExist;
    }

    public boolean isExist() {
        return exist;
    }

    public static Bar of(boolean isExist) {
        return isExist ? IS_EXIST : NOT_EXIST;
    }
}
