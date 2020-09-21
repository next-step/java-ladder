package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder() {
        lines = new ArrayList<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void makeLines(List<User> userNames, int height) {
        int countOfPerson = userNames.size();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public void startGame() {
        for (int i = 0; i < lines.size(); i++) {
            Point startPoint = lines.get(0).getPoints().get(i);
            lines.get(0).goDownLadder(startPoint);

        }

    }
}
