package nextstep.ladder.model.factory;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.strategy.PointPickerStrategy;

public class LadderFactory {
    private static final String INVALID_LADDER_LENGTH_EXCEPTION_MESSAGE = "사다리의 높이는 양수여야 합니다.";

    public static Ladder create(int ladderLength, int countOfPerson, PointPickerStrategy strategy) {
        validate(ladderLength);
        List<Line> lines = IntStream.range(0, ladderLength)
            .mapToObj(idx -> LineFactory.create(countOfPerson, strategy))
            .collect(toList());

        return new Ladder(lines);
    }

    private static void validate(int ladderLength) {
        if (ladderLength <= 0) {
            throw new IllegalArgumentException(INVALID_LADDER_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
