package ladder;

import ladder.lineMaker.LineMakerRandom;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> ladder;

    private Ladder(int height, int countOfPlayer) {
        countOfPlayer -= 1;
        this.ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.ladder.add(new Line(countOfPlayer, new LineMakerRandom()));
        }
    }

    public static Ladder of(int height, int countOfPlayer) {
        return new Ladder(height, countOfPlayer);
    }

    public static Ladder of(String height, String countOfPlayer) {
        return new Ladder(Integer.valueOf(height), Integer.valueOf(countOfPlayer));
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

    public int getSize() {
        return this.ladder.size();
    }
}
