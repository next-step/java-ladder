package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Draw> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 1; i < countOfPerson; i++) {
            this.points.add(new Draw(getLastDraw()));
        }
    }

    public int getLineCount() {
        return points.size();
    }

    public Draw getDrawByPosition(int position) {
        return points.get(position);
    }

    public Draw getLastDraw() {
        return points.stream()
                .reduce((beforeDraw, afterDraw) -> afterDraw)
                .orElse(new Draw(RandomGenerator.getRandom()));
    }

    public int getDrawLineCount() {
        return (int) points.stream()
                        .count();
    }

}
