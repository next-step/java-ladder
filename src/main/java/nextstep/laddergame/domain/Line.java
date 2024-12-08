package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Cross> crosses;

    public Line(List<Boolean> crosses) {
        this.crosses = createCrosses(crosses);
    }

    private static List<Cross> createCrosses(List<Boolean> crosses) {
        List<Cross> tempCrosses = new ArrayList<>();

        for (int position = 0; position < crosses.size(); position++) {
            if (isFirst(position)) {
                tempCrosses.add(Cross.first(crosses.get(position)));
                continue;
            }
            if (isLast(crosses, position)) {
                tempCrosses.add(Cross.last(position, crosses.get(position - 1)));
                continue;
            }
            tempCrosses.add(tempCrosses.get(position - 1).next(crosses.get(position)));
        }
        return tempCrosses;
    }

    private static boolean isFirst(int index) {
        return index == 0;
    }

    private static boolean isLast(List<Boolean> crosses, int index) {
        return crosses.size() - 1 == index;
    }

    public int move(int position) {
        return crosses.get(position).move();
    }

    public List<Cross> values() {
        return crosses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(crosses, line.crosses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosses);
    }
}
