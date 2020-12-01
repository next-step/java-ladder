package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> spoke;

    public Line(List<Boolean> spoke) {
        this.spoke = spoke;
    }

    public boolean hasSpokeRightSide(Position position) {
        return spoke.get(position.toInt());
    }

    public Stream<Boolean> toSpokeStream() {
        return spoke.stream();
    }

    public Position moveOn(Position from) {
        // TODO spoke 보다 크거나 0보다 작은 숫자는 예외발생!

        if (spoke.size() == from.toInt()) {
            return moveWithSpoke(from, lastSpoke(), - 1);
        }
        return moveWithSpoke(from, spoke.get(from.toInt()), 1);
    }

    private Position moveWithSpoke(Position from, Boolean spokeExists, int amount) {
        if (spokeExists) {
            return Position.of(from.toInt() + amount);
        }
        return from;
    }

    private boolean lastSpoke() {
        return spoke.get(spoke.size() - 1);
    }
}
