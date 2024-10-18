package laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LadderPositionResult {
    private final Map<Position, String> resultByPosition;

    public LadderPositionResult(List<String> gameResults) {
        this(createResultByPosition(gameResults));
    }

    public LadderPositionResult(Map<Position, String> resultByPosition) {
        this.resultByPosition = resultByPosition;
    }

    private static Map<Position, String> createResultByPosition(List<String> gameResults) {
        return IntStream.range(0, gameResults.size())
                .boxed()
                .collect(toMap(
                        Position::new,
                        gameResults::get
                ));
    }

    public String findBy(int position) {
        return resultByPosition.get(new Position(position));
    }

    public Map<Position, String> getResultByPosition() {
        return resultByPosition;
    }
}
