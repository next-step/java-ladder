package nextstep.ladder.model.ladder;

import nextstep.ladder.exception.EndPointsLengthException;
import nextstep.ladder.exception.LadderLengthException;

import java.util.List;
import java.util.Optional;

import static nextstep.ladder.model.ConstantNumber.TWO;
import static nextstep.ladder.model.ConstantNumber.ZERO;

public class Ladder {

    private final Lines lines;
    private final EndPoints endPoints;

    private Ladder(Lines lines, EndPoints endPoints) {
        this.lines = lines;
        this.endPoints = endPoints;
    }

    private static void isMinimumLines(Lines lines) {
        Optional.ofNullable(lines.unwrap())
                .map(List::size)
                .filter(size -> TWO.getValue() < size)
                .orElseThrow(LadderLengthException::new);
    }

    private static void isMinimumEndPoints(int minimumCount, EndPoints endPoints) {
        Optional.ofNullable(endPoints.unwrap())
                .map(List::size)
                .filter(size -> minimumCount == size)
                .orElseThrow(EndPointsLengthException::new);
    }

    public static Ladder create(int countOfPeople, int maxHeight, List<String> scores) {
        Lines lines = Lines.of(countOfPeople, maxHeight);
        isMinimumLines(lines);

        EndPoints endPoints = EndPoints.of(scores);
        isMinimumEndPoints(countOfPeople, endPoints);
        return Ladder.create(lines, endPoints);
    }

    public static Ladder create(Lines lines, EndPoints endPoints) {
        return new Ladder(lines, endPoints);
    }

    public EndPoint findEndPoint(int startColumn) {
        int endColumn = this.lines.moveDown(ZERO.getValue(), startColumn);
        return this.endPoints.endPoint(endColumn);
    }

    public Lines lines() {
        return this.lines;
    }

    public EndPoints endPoints() {
        return this.endPoints;
    }
}
