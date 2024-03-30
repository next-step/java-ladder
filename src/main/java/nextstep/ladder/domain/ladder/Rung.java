package nextstep.ladder.domain.ladder;

/**
 * 사다리 가로대(발판)
 */
public enum Rung {
    EXIST(true),
    EMPTY(false),
    ;

    private final boolean exist;

    Rung(boolean exist) {
        this.exist = exist;
    }

    public boolean exist() {
        return this.exist;
    }

}
