package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private ArrayList<Line> ladder;

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
        ArrayList<List<Boolean>> result = new ArrayList<>();
        ladder.forEach(line -> result.add(line.getLine()));
        return result;
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "ladder=" + ladder +
            '}';
    }
}
