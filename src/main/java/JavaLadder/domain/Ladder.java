package JavaLadder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int listSize) {
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
        return (int) Arrays.asList(ladder).stream().filter(n -> true).count();
    }

    public void moveForResult(UserList userList) {
        for (int i = 0; i < userList.size(); i++) {
            Point point = userList.getUserPoint(userList.getName(i));
            moveLadder(point);
        }
    }

    private void moveLadder(Point point) {
        for (int i = 0; i < ladder.size(); i++) {
            Line line = (Line) ladder.get(i);
            if(line.countLine() == 0){
                continue;
            }
            line.moveByLine(point);
        }
    }

}
