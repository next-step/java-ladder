package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Dot> dots;

    public Line(int userCount) {
        this.dots = initializeDots(userCount);
    }

    private static List<Dot> initializeDots(int count) {
        List<Dot> dots = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            dots.add(Dot.ofInitDot(i));
        }
        return dots;
    }

    public void buildLine(Boolean isBridgeTarget) {
        dots.stream().forEach(dot -> dot.toLine(this));
        dots.stream().forEach(dot-> dot.setDot(isBridgeTarget));
    }

    public List<Boolean> getDots() {
        return dots.stream().map(dot->dot.getValue()).collect(Collectors.toList());
    }

    public boolean getDotValue(int index) {
        return dots.get(index).getValue();
    }

    public int getLengthOfLine() {
        return dots.size();
    }

}
