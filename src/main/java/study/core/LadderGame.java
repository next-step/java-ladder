package study.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final List<PlayerName> names;
    private final int height;

    public LadderGame(List<PlayerName> names, int height) {
        this.names = names;
        this.height = height;
    }

    public Ladder createLadder() {
        List<Line> ladder = new ArrayList<>();
        IntStream.range(0, height).forEach(i -> {
            Line line = new Line(new ArrayList<>());
            line.createPoints(names.size());
            ladder.add(line);
        });
        return new Ladder(ladder);
    }

    public Result play(Ladder ladder, List<Prize> prizes) {
        Map<PlayerName, Prize> results = IntStream.range(0, names.size())
                .boxed()
                .collect(Collectors.toMap(names::get, i -> prizes.get(playForPlayer(ladder, i))));
        return new Result(results);
    }

    public int playForPlayer(Ladder ladder, int startPosition) {
        int currentPosition = startPosition;
        for (Line line : ladder.getLines()) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

}
