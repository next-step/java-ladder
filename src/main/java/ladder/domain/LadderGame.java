package ladder.domain;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Users users, Height height) {
        this.ladder = new Ladder(users.count(), height.value());
    }

    public Ladder execute() {
        return ladder;
    }
}
