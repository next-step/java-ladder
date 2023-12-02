package ladder.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGame {

    private final List<Line> lines;

    public LadderGame(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderGame start(final int lineHeight, final int playersCount, RandomStrategy randomStrategy) {
        List<Line> lines = Stream.generate(() -> Line.create(playersCount, randomStrategy))
                .limit(lineHeight)
                .collect(Collectors.toList());

        return new LadderGame(lines);
    }

    public LadderResult result(List<Player> players, List<Prize> prizes) {
        Map<Player, Prize> results = new LinkedHashMap<>();
        IntStream.range(0, players.size())
                .forEach(index -> results.put(players.get(index), prizes.get(move(index, this.lines))));

        return new LadderResult(results);
    }

    public int move(int playerPosition, List<Line> lines) {
        int resultIndex = playerPosition;

        for (Line line : lines) {
            resultIndex = line.move(resultIndex);
        }

        return resultIndex;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
