package ladder.domain;

public class LadderResult {
    private Result result;

    public LadderResult(Users users, Rewards rewards, Ladder ladder) {
        downLadder(users, rewards, ladder);
    }

    private void downLadder(Users users, Rewards rewards, Ladder ladder) {
        users.getUsers()
                .forEach(user -> {
                    int position = users.getUserPosition(user.getUserName());
                    for (LadderLine ladderLine : ladder.getLadder()) {
                        position = ladderLine.move(position);
                    }
                    result = new Result(user, rewards.getRewards().get(position));
                });

    }

    public Result getResult() {
        return result;
    }

}
