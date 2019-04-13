package domain;

import domain.ladder.Goals;
import domain.ladder.Ladder;
import domain.result.Results;
import domain.user.Users;

public class LadderGame {
    private static final String USER_ALL = "all";

    private Ladder ladder;
    private Users users;

    public LadderGame(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public Results result(String userName, Goals goals) {
        if (USER_ALL.equals(userName)) {
            return findAll(goals);
        }
        return findOne(userName, goals);
    }

    private Results findAll(Goals goals) {
        Results results = new Results();
        for (int i = 0; i < users.size(); i++) {
            int position = ladder.result(i);
            results.add(users.getUserName(i), goals.findGoal(position));
        }
        return results;
    }

    private Results findOne(String userName, Goals goals) {
        Results results = new Results();
        int position = ladder.result(users.findPositionByName(userName));
        results.add(userName, goals.result(position));
        return results;
    }
}
