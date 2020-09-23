package domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<User> startGame(List<User> users,String[] results) {

        for (int i = 0; i < users.size(); i++) {

            int result = lines.get(0).goDownLadder(this.lines, i, 1);
            System.out.println(result);
            users.get(i).setGameResult(results[result]);
            System.out.println(results[result]);
        }
        return  users;
    }
}
