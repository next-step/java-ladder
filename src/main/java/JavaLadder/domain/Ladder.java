package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, GameInformation gameInformation) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(gameInformation);
            ladder.add(line);
        }
    }

    public int size() {
        return ladder.size();
    }

    public void moveForResult(GameInformation gameInformation) {
        Users users = gameInformation.getUsers();
        for (int i = 0; i < users.size(); i++) {
            Point point = users.getUserPoint(users.getName(i));
            moveLadder(point);
        }
    }

    private void moveLadder(Point point) {
        for (int i = 0; i < ladder.size(); i++) {
            moveLine(point, getLineByLadder(i));
        }
    }

    private void moveLine(Point point, Line line) {
        if (line.onlyFalse()) {
            return;
        }
        line.isMove(point);
    }

    public Line getLineByLadder(int index) {
        return ladder.get(index);
    }
}
