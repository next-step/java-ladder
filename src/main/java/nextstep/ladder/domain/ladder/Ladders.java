package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Stream;

public class Ladders {

    private List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        removeDuplicateHorizontalLines(ladders);
        this.ladders = ladders;
    }

    private void removeDuplicateHorizontalLines(List<Ladder> ladders) {
        for (int i = 1; i < ladders.size(); i++) {
            Ladder prevLadder = ladders.get(i - 1);
            Ladder ladder = ladders.get(i);

            ladder.removeDuplicatedHorizontalLines(prevLadder);
        }
    }

    public Stream<Ladder> stream() {
        return ladders.stream();
    }
}
