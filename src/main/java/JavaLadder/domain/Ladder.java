package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int listSize) {
        for (int i = 0; i < height; i++) {
            Line line = new Line((listSize));
            this.ladder.add(line);
        }
    }

    public int size() {
        return this.ladder.size();
    }

    public Line getLadder(int index) {
        return this.ladder.get(index);
    }
}
