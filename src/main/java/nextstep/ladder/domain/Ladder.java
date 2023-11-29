package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    public static final String LADDER_POLE = "|";
    private static final String LINE_BREAK = "\n";

//    private final List<Points> ladder;
    private final List<Bridges> ladder;

//    public Ladder(List<Points> ladder) {
//        this.ladder = ladder;
//    }

    public Ladder(List<Bridges> ladder) {
        this.ladder = ladder;
    }

    public int climb(int startPosition) {
        return ladder.stream()
            .reduce(startPosition, (current, points) -> points.move(current), (a, b) -> b);
    }

    @Override
    public String toString() {
        return null;
    }

    private String setUpSide(Bridges bridges) {
        return LADDER_POLE + bridges.toString() + LADDER_POLE;
    }
}
