package domain;

import java.util.ArrayList;
import java.util.List;

import static view.View.FIRST_HEIGHT;
import static view.View.ZERO;

public class Ladder {
    private List<Line> lines;
    static int LADDER_HEIGHT;

    public Ladder() {
        lines = new ArrayList<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void makeLines(List<User> userNames, int height) {
        int countOfPerson = userNames.size();
        LADDER_HEIGHT = height;

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public void startGame(List<User> users, String[] results) {
        for (int startIndex = 0; startIndex < users.size(); startIndex++) {
            int result = lines.get(ZERO).goDownLadder(this.lines, startIndex, FIRST_HEIGHT);
            users.get(startIndex).setGameResult(results[result]);
        }
    }
}
