package ladder;

import ladder.lineMaker.LineMakerRandom;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final int MIN_HEIGTH = 3;
    public static final int MAX_HEIGTH = 100;
    private List<Line> ladder;

    private Ladder(int height, int countOfPlayer) {
        if (height > MAX_HEIGTH || height < MIN_HEIGTH){
            throw new IllegalArgumentException();
        }
        countOfPlayer -= 1;
        this.ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.ladder.add(new Line(countOfPlayer, new LineMakerRandom()));
        }
    }

    public static Ladder of(int height, int countOfPlayer) {
        return new Ladder(height, countOfPlayer);
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

}
