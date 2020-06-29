package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private static final String INVALID_USER_NAME = "all 혹은 게임에 참여하는 사람만 조회할 수 있습니다.";
    private static final String COMMAND_ALL = "all";

    private List<Result> results;

    public GameResult(List<User> users, Results results) {
        this.results = new ArrayList<>();
        users.stream()
            .forEach(user -> this.results
                .add(new Result(user, results.getResult(user.getCurrentPosition()))));
    }

    public List<String> toStringList(String userName) {
        List<String> results = new ArrayList<>();
        if (userName.equals(COMMAND_ALL)) {
            this.results.forEach(result -> results.add(result.toString()));
            return results;
        }

        results.add(this.results.stream()
            .filter(result -> result.getUserName().equals(userName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_USER_NAME))
            .getResult());

        return results;
    }
}
