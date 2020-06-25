package nextstep.ladder.domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder;

    public Ladder(int height, int countOfPerson) {
        ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson-1, new RandomGenerableStrategy()));
        }
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "ladder=" + ladder +
            '}';
    }
}
