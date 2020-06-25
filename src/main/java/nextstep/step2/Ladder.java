package nextstep.step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final int numberOfPeople;
    private final int height;
    private final List<Lines> ladder;

    public Ladder(int numberOfPeople, int height) {
        this.numberOfPeople = numberOfPeople;
        this.height = height;
        this.ladder = createLadder();
    }

    public List<Lines> createLadder() {
        return IntStream.range(0,height)
                .mapToObj(index -> Lines.of(numberOfPeople))
                .collect(Collectors.toList());
    }

    public List<Lines> getLadder() {
        return ladder;
    }
}
