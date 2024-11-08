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
        int lastIndex = count - 1;

        dots.add(0, Dot.firstDot(firstDotValue));
        for (int i = 0; i < lastIndex-1 ; i++) {
            dots.add(i+1,dots.get(i).nextDot());
        }
        dots.add(Dot.lastDot(lastIndex,dots.get(lastIndex-1).getValue()));

        return dots;
    }

    public List<Boolean> getDots() {
        return dots.stream()
                .map(Dot::getValue)
                .collect(Collectors.toList());
    }

    public int getLineIndex(int index) {
        return dots.get(index).getMoveStep();
    }
}
