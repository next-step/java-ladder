package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderCreator {

    private final int countOfPerson;
    private final int height;

    private LadderCreator(final int countOfPerson, final int height) {

        this.countOfPerson = countOfPerson;
        this.height = height;
    }

    public static LadderCreator of(final int countOfPerson, final int height) {

        return new LadderCreator(countOfPerson, height);
    }

    public Ladder create() {

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            lines.add(LineCreator.create(this.countOfPerson));
        }
        return new Ladder(lines);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderCreator that = (LadderCreator) o;
        return countOfPerson == that.countOfPerson && height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(countOfPerson, height);
    }
}
