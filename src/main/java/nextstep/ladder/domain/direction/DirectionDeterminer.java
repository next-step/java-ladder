package nextstep.ladder.domain.direction;

public class DirectionDeterminer {

    private boolean before;
    private final LineGenerator lineGenerator;

    public DirectionDeterminer(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Direction next() {
        return next(lineGenerator.generate(before));
    }

    public Direction next(boolean current) {
        if (before && current) {
            throw new IllegalArgumentException("유효하지 않은 사다리 라인");
        }
        if (!before && current) {
            before = true;
            return Direction.RIGHT_DOWN;
        }
        if (before) {
            before = false;
            return Direction.LEFT_DOWN;
        }
        return Direction.DOWN;
    }

    public Direction last() {
        return next(false);
    }
}
