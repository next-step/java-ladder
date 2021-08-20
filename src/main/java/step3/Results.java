package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(List<String> resultValues) {
        results = createResults(resultValues);
    }

    private List<Result> createResults(List<String> resultValues) {
        return IntStream.range(0, resultValues.size())
                .mapToObj(i -> new Result(resultValues.get(i), new Position(i)))
                .collect(Collectors.toList());
    }

    public List<Result> findResultsByPositions(List<Position> positions) {
        return positions.stream()
                .map(this::getResultByPosition)
                .collect(Collectors.toList());
    }

    private Result getResultByPosition(Position position) {
        return results.stream()
                .filter(r -> r.isSamePosition(position))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<String> resultStrings() {
        return results.stream()
                .map(Result::toOutputString)
                .collect(Collectors.toList());
    }
}
