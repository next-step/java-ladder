package ladder.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private List<Line> lines;

    public LadderGame(int height, int userCount) {
        this.lines = initializeLines(height, userCount);
    }

    private static List<Line> initializeLines(int height, int userCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(userCount, new RandomDecision()));
        }
        return lines;
    }

    public List<String> getShapeOfLadderAsList() {
        return lines.stream()
                .map(Line::getShapeOfLine)
                .collect(Collectors.toList());
    }

}
