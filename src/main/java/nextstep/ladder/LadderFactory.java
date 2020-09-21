package nextstep.ladder;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderFactory {

    public static Ladder generate(int height, int countOfPerson, PointGenerator trueOfFalse) {
        return IntStream.range(0, height)
                .mapToObj(num -> PointsFactory.generate(countOfPerson - 1, trueOfFalse))
                .map(Line::of)
                .collect(collectingAndThen(toList(), (lines) -> Ladder.of(height, countOfPerson, lines)));
    }
}
