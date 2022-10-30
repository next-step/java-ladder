package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int height;
    public final List<Line> lines;

    public Ladder(int height) {
        this.height = height;
        this.lines = new ArrayList<>(height);
    }

    public void createLadderGame(int userCounts) {
        for (int i = 0; i < this.height; i++) {
            this.lines.add(new Line(userCounts));
        }
    }

}
