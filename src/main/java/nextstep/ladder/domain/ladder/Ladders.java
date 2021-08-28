package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladders {

    private final int height;
    private final List<Ladder> ladders = new ArrayList<>();

    public Ladders(List<Ladder> ladders, int height) {
        this.ladders.addAll(ladders);
        this.height = height;
        reArrangeLadder();
    }

    public Stream<Ladder> stream() {
        return ladders.stream();
    }

    private void reArrangeLadder() {
        for (int i = 1; i < ladders.size(); i++) {
            Ladder leftNeighborhoodLadder = ladders.get(i - 1);
            Ladder ladder = ladders.get(i);
            ladder.reArrangeConnectPoints(leftNeighborhoodLadder);
        }
    }

    public int getLevel() {
        return height;
    }


}
