package ladder.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGame {

    private final Map<Player, Prize> results;

    public LadderGame(Map<Player, Prize> results) {
        this.results = results;
    }

    public static List<Line> start(final int lineHeight, final int playersCount, RandomStrategy randomStrategy) {
        return Stream.generate(() -> Line.create(playersCount, randomStrategy))
                .limit(lineHeight)
                .collect(Collectors.toList());
    }

    public static LadderGame result(List<Player> players, List<Line> lines, List<Prize> prizes) {
        Map<Player, Prize> results = new LinkedHashMap<>();
        IntStream.range(0, players.size())
                .forEach(index -> results.put(players.get(index), prizes.get(move(index, lines))));

        return new LadderGame(results);
    }

    public Map<Player, Prize> getResults() {
        return this.results;
    }

    public static int move(int playerPosition, List<Line> lines) {
        int resultIndex = playerPosition;

        for (Line line : lines) {
            resultIndex = line.move(resultIndex);
        }

        return resultIndex;
    }
}
