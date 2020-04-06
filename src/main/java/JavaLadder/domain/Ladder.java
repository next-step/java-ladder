package JavaLadder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, GameInformation gameInformation) {
        int listSize = gameInformation.getUsers().size();
        for (int i = 0; i < height; i++) {
            Line line = new Line((listSize));
            this.ladder.add(line);
        }
    }

    public int size() {
        return this.ladder.size();
    }

    public Line getLadder(int index) {
        return this.ladder.get(index);
    }

    public int countLadder() {
        return (int) Arrays.asList(ladder).stream()
                .filter(n -> true).count();
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
            moveLine(point, i);
        }
    }

    private void moveLine(Point point, int index) {
        Line line = (Line) ladder.get(index);
        if(line.countLine() == 0){
            return;
        }
        line.moveByLine(point);
    }

}
