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
        List<MyLine> myLineList = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            MyLine line = new MyLine(createLine(userCount));
            myLineList.add(line);
        }
        return myLineList;
    }

    private List<Direction> createLine(int userCount) {
        List<Direction> directionList = new ArrayList<>();
        Direction direction = new Direction();
        directionList.add(direction);

        while (beforeLastDirection(directionList, userCount)) {
            direction = direction.next();
            directionList.add(direction);
        }

        directionList.add(direction.last());
        return directionList;
    }

    private boolean beforeLastDirection(List<Direction> directionList, int userCount) {
        return directionList.size() < userCount - 1;
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
