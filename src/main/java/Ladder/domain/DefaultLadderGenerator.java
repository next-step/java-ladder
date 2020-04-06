package Ladder.domain;

import Ladder.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderGenerator implements LadderGenerator {

    private static final int DEFAULT_NUMBER_OF_PEOPLE = 2;

    @Override
    public Ladder generate(final int peopleCount, final int height) {
        validatePeopleNumber(peopleCount);
        return Ladder.of(IntStream
                .range(1, height)
                .mapToObj(num -> generator(peopleCount))
                .collect(Collectors.toList()))
                ;
    }

    private void validatePeopleNumber(final int peopleCount) {
        if (peopleCount < DEFAULT_NUMBER_OF_PEOPLE) {
            throw new IllegalArgumentException("People must more than 2, current : " + peopleCount);
        }
    }

    private Line generator(final int peopleCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(RandomUtils.booleanRandom());

        for (int i = 1; i < peopleCount - 1; i++) {
            points.add(getCurrentRandomValue(points.get(i - 1)));
        }

        return Line.of(points);
    }

    private boolean getCurrentRandomValue(final boolean prevValue) {
        return !prevValue && RandomUtils.booleanRandom();
    }
}
