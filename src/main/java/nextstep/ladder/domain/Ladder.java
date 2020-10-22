package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Lines lines;
    private final Users users;
    private final Rewards rewards;

    public Ladder(Lines lines, Users users, Rewards rewards) {
        this.lines = lines;
        this.users = users;
        this.rewards = rewards;
    }

    public static Ladder random(String usersRaw, String rewardsRaw, int height) {
        Users users = Users.ofByRaw(usersRaw);
        Lines lines = Lines.random(users.countOfUsers(), height);
        Rewards rewards = Rewards.ofByRaw(rewardsRaw);
        return new Ladder(lines, users, rewards);
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public Results getResultsOfUsers() {
        List<Result> results = new ArrayList<>();
        for (int idx = 0; idx < users.size(); idx++) {
            Result result = Result.of(users.findUsernameByIdx(idx), rewards.findByIdx(lines.down(idx)));
            results.add(result);
        }
        return new Results(results);
    }

    public int getMaxUserNameLength() {
        return users.getMaxUserNameLength();
    }

    public Result getResultByUsername(String username) {
        int userIdx = users.getIdxByUsername(username);
        int col = lines.down(userIdx);
        return Result.of(username, rewards.findByIdx(col));
    }
}
