package nextstep.version.refactor.domain;

public enum Direction {
    NEXT(1),
    PASS(0),
    BEFORE(-1),
    NONE(-2);

    private final Integer directionValue;

    Direction(Integer directionValue) {
        this.directionValue = directionValue;
    }

    public Integer getDirectionValue() {
        return directionValue;
    }
}
