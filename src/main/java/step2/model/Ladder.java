package step2.model;

import step2.strategy.RandomDrawStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int height, int countOfPeople) {
        ladder = Stream.generate(Line::new)
                .limit(height)
                .collect(Collectors.toList());
        ladder.forEach(it -> it.drawNewLine(countOfPeople, new RandomDrawStrategy()));
    }

    public Line getLineOfHeight(int height) {
        return ladder.get(height);
    }

    public int getHeightOfLadder() {
        return ladder.size();
    }
}
