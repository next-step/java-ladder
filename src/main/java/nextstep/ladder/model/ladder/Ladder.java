package nextstep.ladder.model.ladder;

import nextstep.ladder.exception.MinimumException;

import java.util.List;
import java.util.Optional;

public class Ladder {

    private static final String MINIMUM_LINE_MESSAGE = "사다리의 행 길이는 최소 2 이상입니다.";
    private static final String MINIMUM_END_POINTS_MESSAGE = "점수 개수는 사다리의 행 길이와 동일 해야합니다.";
    private static final int MINIMUM_ROW_LENGTH = 2;

    private final Lines lines;
    private final EndPoints endPoints;

    private Ladder(Lines lines, EndPoints endPoints) {
        this.lines = lines;
        this.endPoints = endPoints;
    }

    private static void isMinimum(Lines lines) {
        Optional.ofNullable(lines.unwrap())
                .map(List::size)
                .filter(size -> MINIMUM_ROW_LENGTH < size)
                .orElseThrow(() -> new MinimumException(MINIMUM_LINE_MESSAGE));
    }

    private static void isMinimum(int minimumCount, EndPoints endPoints) {
        Optional.ofNullable(endPoints.unwrap())
                .map(List::size)
                .filter(size -> minimumCount == size)
                .orElseThrow(() -> new MinimumException(MINIMUM_END_POINTS_MESSAGE));
    }

    public static Ladder create(int countOfPeople, int maxHeight, List<String> scores) {
        Lines lines = Lines.of(countOfPeople, maxHeight);
        isMinimum(lines);

        EndPoints endPoints = EndPoints.of(scores);
        isMinimum(countOfPeople, endPoints);
        return new Ladder(lines, endPoints);
    }

    public Lines lines() {
        return this.lines;
    }

    public EndPoints endPoints() {
        return this.endPoints;
    }
}
