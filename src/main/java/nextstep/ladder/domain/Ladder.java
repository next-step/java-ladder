package nextstep.ladder.domain;

public class Ladder {

    private final Users users;
    private final int height;
    private final LadderRows ladderRows;

    public Ladder(Users users, int height) {
        this.users = users;
        this.height = height;
        this.ladderRows = new LadderRows(users, height);
    }
}
