package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Boolean> value;

    public Ladder(int personCount) {
        value = initLadder(personCount);
    }

    private List<Boolean> initLadder(int personCount) {
        TransverseLadder transverseLadder = new TransverseLadder(personCount);

        return IntStream.range(0, transverseLadder.size() + personCount)
                .mapToObj(index -> getLadderPoint(index, transverseLadder))
                .collect(Collectors.toList());
    }

    private Boolean getLadderPoint(int i, TransverseLadder transverseLadder) {
        if (i % 2 == 1) {
            return getPoint(transverseLadder.getPoints().get(i / 2));
        }
        return true;
    }

    private Boolean getPoint(Boolean before) {
        if (Boolean.TRUE.equals(before)) {
            return true;
        }
        return false;
    }

    public List<Boolean> getValue() {
        return value;
    }
}
