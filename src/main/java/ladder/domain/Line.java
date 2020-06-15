package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Draw> points = new ArrayList<>();

    public Line (int countOfPerson) {
        boolean isDraw = RandomGenerator.getRandom();
        for (int i = 0; i < countOfPerson; i++) {
            this.points.add(new Draw(isDraw));
            isDraw = (isDraw) ? false : RandomGenerator.getRandom();
        }
    }

    public int getLineCount() {
        return points.size();
    }

    public int getDrawLineCount() {
        return (int) points.stream()
                        .filter(draw -> Draw.of(true).equals(draw))
                        .count();
    }

}
