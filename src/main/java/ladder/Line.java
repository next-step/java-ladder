package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private int countOfPerson;

    public Line (int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return countOfPerson == line.countOfPerson &&
                Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, countOfPerson);
    }
}
