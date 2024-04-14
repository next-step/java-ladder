package nextstep.ladder.domain.ladder;

import java.util.Optional;

/**
 * 사다리 가로대(발판)
 */
public enum Connection {
    EXIST(true),
    EMPTY(false),
    ;

    private final boolean exist;

    Connection(boolean exist) {
        this.exist = exist;
    }

    public static Connection from(boolean value) {
        if (value) {
            return EXIST;
        }
        return EMPTY;
    }

    public Connection generate(RungGenerateStrategy generateStrategy) {
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
