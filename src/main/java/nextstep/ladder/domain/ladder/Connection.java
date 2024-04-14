package nextstep.ladder.domain.ladder;

import java.util.Optional;

/**
 * 사다리 가로대(발판) 연결여부
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

    /**
     * 생성 방향은 우측으로만 한정한다.
     */
    public Direction generateDirection() {
        if (this == EXIST) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

}
