package ladder.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Ladder {
    private int height;
    private ArrayList<Line> ladder;

    public Ladder(int height, int countOfPerson) {
        ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
        this.height = height;
    }

    public ArrayList<Line> getLadder() {
        return new ArrayList<>(ladder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
