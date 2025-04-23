package nextstep.ladder;

import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.strategy.RandomStrategy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final List<String> result;

    public Ladder(Players players, int height, String result) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount(), new RandomStrategy(new RandomGenerator())))
                .collect(Collectors.toList());
        this.result = List.of(result.split(","));
    }

    public Ladder(Players players, int height, String result, LineStrategy lineStrategy) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount(), lineStrategy))
                .collect(Collectors.toList());
        this.result = List.of(result.split(","));
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getResult() {
        return result;
    }

    public GameResult play(Players players) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < players.getCount(); i++) {
            String name = players.getPlayers().get(i).getName();
            int finalPosition = calculateFinalPosition(i);
            resultMap.put(name, result.get(finalPosition));
        }
        return new GameResult(resultMap);
    }

    private int calculateFinalPosition(int startIndex) {
        int position = startIndex;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
