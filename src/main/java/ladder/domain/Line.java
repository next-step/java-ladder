package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Dot> dots;

    public Line(int userCount, Boolean firstDotValue) {
        this.dots = initializeDots(userCount, firstDotValue);
    }

    private static List<Dot> initializeDots(int count, Boolean firstDotValue) {
        List<Dot> dots = new ArrayList<>();
        dots.add(0, new Dot(firstDotValue));

        for (int i = 1; i < count - 1; i++) {
            Boolean preDotValue = dots.get(i - 1).getValue();
            dots.add(i, new Dot(!preDotValue));
        }

        dots.add(count - 1, new Dot(false));

        return dots;
    }

    public List<Boolean> getDots() {
        return dots.stream()
                .map(Dot::getValue)
                .collect(Collectors.toList());
    }

    public int getLineIndex(int index) {
        if (index == 0) {
            return getFirstDotIndex(index);
        }
        if (index == dots.size() - 1) {
            return getLastDotIndex(index);
        }
        return getMiddleDotIndex(index);
    }

    private int getMiddleDotIndex(int index) {
        if (dots.get(index - 1).getValue()) {
            return index - 1;
        }
        if (dots.get(index).getValue()) {
            return index + 1;
        }
        return index;
    }

    private int getLastDotIndex(int index) {
        if (dots.get(index - 1).getValue()) {
            return index - 1;
        }
        return index;
    }

    private int getFirstDotIndex(int index) {
        if (dots.get(index).getValue()) {
            return index + 1;
        }
        return index;
    }
}
