package nextstep.ladder;

import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.strategy.RandomStrategy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final List<Prize> prizes;

    public Ladder(Players players, int height, String result) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount(), new RandomStrategy(new RandomGenerator())))
                .collect(Collectors.toList());

        this.prizes = Arrays.stream(result.split(","))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Ladder(Players players, int height, String result, LineStrategy lineStrategy) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount(), lineStrategy))
                .collect(Collectors.toList());

        this.prizes = Arrays.stream(result.split(","))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public GameResult play(Players players) {
        Map<Player, Prize> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < players.getCount(); i++) {
            int finalPosition = calculateFinalPosition(i);
            resultMap.put(players.getPlayers().get(i), prizes.get(finalPosition));
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
