package step2.model;

import step2.strategy.RandomDrawStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private List<Line> ladder;

    public Ladder(Height height, int countOfPeople) {
        this.ladder = Stream.generate(Line::new)
                .limit(height.getHeight())
                .peek(it -> it.drawNewLine(countOfPeople, new RandomDrawStrategy()))
                .collect(toList());
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(List<Line> ladder) {
        return new Ladder(ladder);
    }


    public Ladder of(int height, int countOfPeople) {
        return Stream.generate(Line::new)
                .limit(height)
                .peek(it -> it.drawNewLine(countOfPeople, new RandomDrawStrategy()))
                .collect(collectingAndThen(toList(), Ladder::of))
                ;
    }

    public Line getLineOfHeight(int height) {
        return ladder.get(height);
    }

    public int getHeightOfLadder() {
        return ladder.size();
    }
}
