package nextstep.ladder.enums;

public enum Direction {
    LEFT(-1),
    CENTER(0),
    RIGHT(1),
    ;

    private int append;

    Direction(int append) {
        this.append = append;
    }
}
