package laddergame.v1.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LadderResult {
    private final LinkedHashMap<Position, String> resultByPosition;

    public LadderResult(List<String> gameResults) {
        this(createResultByPosition(gameResults));
    }

    public LadderResult(LinkedHashMap<Position, String> resultByPosition) {
        this.resultByPosition = resultByPosition;
    }

    private static LinkedHashMap<Position, String> createResultByPosition(List<String> gameResults) {
        return IntStream.range(0, gameResults.size())
                .boxed()
                .collect(toMap(
                        Position::new,
                        gameResults::get,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
    }

    public String findBy(int position) {
        return resultByPosition.get(new Position(position));
    }

    public List<String> getGameResultByInputOrder(){
        return new ArrayList<>(this.resultByPosition.values());
    }
}
