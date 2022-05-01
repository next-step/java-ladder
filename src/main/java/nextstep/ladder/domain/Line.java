package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final Bridges bridges;

    Line(int width) {
        bridges = new Bridges(width);
    }

    public void apply(Participants participants) {
        bridges.apply(participants);
    }

    public List<Boolean> getBridges() {
        return bridges.getBridges();
    }
}
