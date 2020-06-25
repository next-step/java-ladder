package nextstep.step2.domain;

import nextstep.step2.exception.Error;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO = 0;

    private final int numberOfPeople;
    private final int height;
    private final List<Lines> ladder;

    public Ladder(int numberOfPeople, int height) {
        checkNegative(numberOfPeople);
        checkNegative(height);
        this.numberOfPeople = numberOfPeople;
        this.height = height;
        this.ladder = createLadder();
    }

    public List<Lines> createLadder() {
        return IntStream.range(ZERO,height)
                .mapToObj(index -> Lines.of(numberOfPeople))
                .collect(Collectors.toList());
    }

    public List<Lines> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    private void checkNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Error.NOT_ALLOW_LESS_THAN_ZERO);
        }
    }
}
