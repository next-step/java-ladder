package nextstep.ladder;

import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        lines = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, new RandomStrategy(new RandomGenerator())));
        }
    }

    public Ladder(Players players, int height) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.getCount(), new RandomStrategy(new RandomGenerator())))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

}
