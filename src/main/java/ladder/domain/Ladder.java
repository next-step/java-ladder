package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;

    public Ladder(int height, int userCount) {
        lineList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lineList.add(new Line(userCount));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lineList.stream().forEach(line -> {
            sb.append(line.toString() + "\n");
        });
        return sb.toString();
    }
}
