package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private int height;
    private int countOfPerson;
    private List<Line> ladder;

    public Ladder(int height, int countOfPerson) {
        ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
        this.height = height;
        this.countOfPerson = countOfPerson;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int getHeight() {
        return height;
    }

    public int getCountOfPerson() {
        return countOfPerson;
    }
}
