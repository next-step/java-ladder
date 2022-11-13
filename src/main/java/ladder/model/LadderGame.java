package ladder.model;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    public LadderGame(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public int arriveAt(String name) {
        return ladder.arriveAt(users.indexOf(name));
    }
}
