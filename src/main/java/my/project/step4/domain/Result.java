package my.project.step4.domain;

import my.project.common.domain.Rewards;
import my.project.common.domain.Users;
import my.project.common.dto.ResultSet;
import my.project.step3.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final Users users;
    private final Ladder ladder;

    public Result(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public List<ResultSet> get(String username, Rewards rewards) {
        if ("all".equals(username)) {
            return resultsAll(rewards);
        }
        return resultOne(username, rewards);
    }

    private List<ResultSet> resultsAll(Rewards rewards) {
        return users.getUsers().stream()
                .map(user -> result(user.getNameValue(), rewards))
                .collect(Collectors.toList());
    }

    private List<ResultSet> resultOne(String username, Rewards rewards) {
        List<ResultSet> resultList = new ArrayList<>();
        resultList.add(result(username, rewards));
        return resultList;
    }

    private ResultSet result(String username, Rewards rewards) {
        int ret = users.getUser(username).getX();
        for (LadderLine line : ladder.getLadder()) {
            ret = line.move(ret);
        }
        return new ResultSet(username, rewards.getReward(ret));
    }
}
