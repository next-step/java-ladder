package nextstep.ladder.domain.ladder;

import java.util.Optional;

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

    public static Rung findByBoolean(boolean value) {
        if (value) {
            return EXIST;
        }
        return EMPTY;
    }

    public static Rung generate(RungGenerateStrategy generateStrategy, Rung adjacentRung) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> findByBoolean(adjacentRung.notExist() && strategy.addable()))
                .orElse(EMPTY);
    }

    public boolean notExist() {
        return !exist();
    }

    public boolean exist() {
        return this.exist;
    }

}
