package nextstep.ladder;

import java.util.List;

class Line {

    private final List<Boolean> spork;

    public Line(List<Boolean> spork) {
        this.spork = spork;
    }

    public boolean hasSporkRightSide(Position position) {
        return spork.get(position.toInt());
    }
}
