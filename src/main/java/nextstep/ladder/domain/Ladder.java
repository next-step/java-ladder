package nextstep.ladder.domain;

public class Ladder {

    private final Users users;
    private final LadderRows ladderRows;

    public Ladder(Users users, int height) {
        this.users = users;
        this.ladderRows = new LadderRows(users, height);
    }

    public Users getUsers() {
        return users;
    }

    public LadderRows getLadderRows() {
        return ladderRows;
    }
}
