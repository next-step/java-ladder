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

    public static Rung from(boolean value) {
        if (value) {
            return EXIST;
        }
        return EMPTY;
    }

    public Rung generate(RungGenerateStrategy generateStrategy) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> from(notExist() && strategy.addable()))
                .orElse(EMPTY);
    }

    public boolean notExist() {
        return !exist();
    }

    public boolean exist() {
        return this.exist;
    }

}
