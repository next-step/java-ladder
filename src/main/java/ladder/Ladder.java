package ladder;

import ladder.lineMaker.PointMakerRandom;

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

        this.ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.ladder.add(new Line(countOfPlayer, new PointMakerRandom()));
        }
    }

    public static Ladder of(int height, int countOfPlayer) {
        return new Ladder(height, countOfPlayer);
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

    private int run(int column, int row) {
        Line ladderLine = ladder.get(row);

        column = ladderLine.move(column);
        row = row + 1;

        if(row < ladderLine.size() - 1) {
            return this.run(column, row);
        }
        return column;
    }

    public int runLadder(int startIndex) {
        return run(startIndex, 0);
    }
}
