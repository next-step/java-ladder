package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Draw> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            this.points.add(new Draw(getLastDraw()));
        }
    }

    public int getLineCount() {
        return points.size();
    }

    public Draw getLastDraw() {
        return points.stream()
                .reduce((f,s) -> s)
                .orElse(new Draw(RandomGenerator.getRandom()));
    }

    public int getDrawLineCount() {
        return (int) points.stream()
                        .filter(draw -> Draw.of(true).equals(draw))
                        .count();
    }

}
