package nextstep.ladder.domain.ladder;

public class Line {

    private final boolean isExist;
    private final Direction direction;

    public Line(boolean isExist, Direction direction) {
        this.isExist = isExist;
        if (!isExist) {
            direction = null;
        }
        this.direction = direction;
    }
}
