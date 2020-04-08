package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, GameInformation gameInformation) {
        Users users = gameInformation.getUser();
        int listSize = users.size();
        for (int i = 0; i < height; i++) {
            Line line = new Line((listSize));
            this.ladder.add(line);
        }
    }

    public int size() {
        return ladder.size();
    }

    public void moveForResult(GameInformation gameInformation) {
        Users users = gameInformation.getUser();
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
        if(line.numberOfTrue() == 0){
            return;
        }
        line.isMove(point);
    }


    public Line getLineByLadder(int index) {
        return this.ladder.get(index);
    }
}
