package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Line> ladder;

    public Ladder(int height, int countOfPerson) {
        ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson - 1, new RandomGenerableStrategy()));
        }
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    public List<List<Boolean>> getLadder() {
        return ladder.stream()
            .map(Line::getLine)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "ladder=" + ladder +
            '}';
    }
}
