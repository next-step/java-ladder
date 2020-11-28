package nextstep.ladder;

import java.util.List;
import java.util.stream.Stream;

class Line {

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
}
