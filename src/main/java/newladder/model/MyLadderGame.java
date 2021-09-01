package newladder.model;


public class MyLadderGame {

    private static final int EMPTY_INDEX = -1;

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
        if (userIndex <= EMPTY_INDEX) {
            return EMPTY_INDEX;
        }
        return this.ladder.downLadder(userIndex);
    }

}
