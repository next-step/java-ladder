package newladder.model;


import java.util.List;

public class MyLadderGame {

    private final MyLadder ladder = new MyLadder();
    private final Users users;

    public MyLadderGame(String[] usersNames, int ladderHeight) {
        users = new Users(usersNames);
        ladder.createLadder(usersNames.length, ladderHeight);
    }

    public Users usersInfo() {
        return this.users;
    }

    public MyLadder ladderInfo() {
        return this.ladder;
    }

    public int playLadder(int userIndex) {
        if (userIndex < 0) {
            return -1;
        }
        return this.ladder.downLadder(userIndex);
    }

}
