package newladder.model;


import java.util.ArrayList;
import java.util.List;

public class MyLadderGame {

    private static final int EMPTY_INDEX = -1;

    private final MyLadder ladder;
    private final Users users;

    public MyLadderGame(String[] usersNames, int ladderHeight) {
        users = new Users(usersNames);
        ladder = new MyLadder(createLadder(usersNames.length, ladderHeight));
    }

    public List<MyLine> createLadder(int userCount, int ladderHeight) {
        List<MyLine> myLines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            MyLine line = new MyLine(createLine(userCount));
            myLines.add(line);
        }
        return myLines;
    }

    private List<Direction> createLine(int userCount) {
        List<Direction> directions = new ArrayList<>();
        Direction direction = new Direction();
        directions.add(direction);

        while (beforeLastDirection(directions, userCount)) {
            direction = direction.next();
            directions.add(direction);
        }

        directions.add(direction.last());
        return directions;
    }

    private boolean beforeLastDirection(List<Direction> directions, int userCount) {
        return directions.size() < userCount - 1;
    }


    public Users usersInfo() {
        return this.users;
    }

    public MyLadder ladderInfo() {
        return this.ladder;
    }

    public int playLadder(int userIndex) {
        if (userIndex <= EMPTY_INDEX) {
            return EMPTY_INDEX;
        }
        return this.ladder.downLadder(userIndex);
    }

}
