package ladder.domain;

public class LadderGameInfo {
    private final Users users;
    private final LadderRewards ladderRewards;

    public static LadderGameInfo of(String users, String rewards) {
        return new LadderGameInfo(Users.of(users), LadderRewards.of(rewards));
    }

    public LadderGameInfo(Users users, LadderRewards ladderRewards) {
        if (users.size() != ladderRewards.size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 한다.");
        }
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
