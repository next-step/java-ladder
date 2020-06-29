package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private Map<String, String> result;

    public GameResult(List<User> users, Results results) {
        this.result = new HashMap<>();
        users.stream()
            .forEach(user -> this.result.put(user.getName(), results.getResult(user.getCurrentPosition())));
    }

    public Map<String, String> getData() {
        return new HashMap<>(this.result);
    }
}
