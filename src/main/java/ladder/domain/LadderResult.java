package ladder.domain;

public class LadderResult {
    private final Users users;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderResult(Users users, Rewards rewards, Ladder ladder) {
        this.users = users;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public Reward move(String userName) {
        int position = users.getUserPosition(userName);
        for (LadderLine ladderLine : ladder.getLadder()) {
            position = ladderLine.move(position);
        }

        return rewards.specificReward(position);
    }

    public Result downLadder() {
        Result result = new Result();
        users.getUsers()
                .forEach(user -> {
                    String name = user.getUserName();
                    Reward reward = move(name);
                    result.addResult(user, reward);
                });

        return result;
    }
}
