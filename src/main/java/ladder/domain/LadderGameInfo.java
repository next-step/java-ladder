package ladder.domain;

public class LadderGameInfo {
    private final Users users;
    private final LadderRewards ladderRewards;

    public static LadderGameInfo of(String users, String rewards) {
        return new LadderGameInfo(Users.of(users), LadderRewards.of(rewards));
    }

    public LadderGameInfo(Users users, LadderRewards ladderRewards) {
        this.users = users;
        this.ladderRewards = ladderRewards;
    }

    public Users getUsers() {
        return users;
    }

    public LadderRewards getLadderRewards() {
        return ladderRewards;
    }
}
