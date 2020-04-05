package ladder;

public class LadderGameResult {
    private final Users users;
    private final Ladder ladder;

    public static LadderGameResult of(Users users, Ladder ladder) {
        return new LadderGameResult(users, ladder);
    }

    private LadderGameResult(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
