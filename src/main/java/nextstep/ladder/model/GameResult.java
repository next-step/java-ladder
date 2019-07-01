package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private List<Integer> positions;

    public GameResult(Ladder ladder, int countOfPerson) {
        this.positions = resultLadder(ladder, countOfPerson);
    }

    public List<Integer> resultLadder(Ladder ladder, int countOfPerson) {
        List<Integer> result = makeCurrentPoints(countOfPerson);
        for (Line line : ladder.getLines()) {
            result = line.lineResult(result);
        }
        return result;
    }

    public int getOnePosition(int firstPoint) {
        return positions.get(firstPoint);
    }

    private List<Integer> makeCurrentPoints(int countOfPerson) {
        return IntStream.range(0, countOfPerson)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
