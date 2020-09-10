package step2.model;

import step2.strategy.DrawStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(List<Line> ladder) {
        return new Ladder(ladder);
    }


    public static Ladder of(Height height, int countOfPeople, DrawStrategy strategy) {
        return Stream.generate(Line::new)
                .limit(height.getHeight())
                .peek(it -> it.drawNewLine(countOfPeople, strategy))
                .collect(collectingAndThen(toList(), Ladder::of))
                ;
    }

    public Line getLineOfHeight(int height) {
        return ladder.get(height);
    }

    public int getHeightOfLadder() {
        return ladder.size();
    }

    public void move(Participants people) {
        for (Line line : ladder) {
            moveInLine(line, people);
        }
    }

    private void moveInLine(Line line, Participants people) {
        Arrays.stream(people.toString().split(" "))
                .peek(it -> line.move(people.findPersonByName(it)))
        ;
    }
}
