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
        return Position.of(1);
    }
}
