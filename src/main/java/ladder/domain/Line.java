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
        dots.add(0, new Dot(0, firstDotValue));

        for (int i = 1; i < count - 1 ; i++) {
            Boolean preDotValue = dots.get(i-1).getValue();
            dots.add(i, new Dot(i,!preDotValue));
        }

        dots.add(count - 1, new Dot(count - 1, false));

        return dots;
    }
    public List<Boolean> getDots() {
        return dots.stream().map(dot->dot.getValue()).collect(Collectors.toList());
    }
}
