package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<User, Prize> result;

    public GameResult(Map<User, Prize> result) {
        this.result = result;
    }

    public GameResult(User user, Prize prize) {
        this.result = new LinkedHashMap<>();
        result.put(user, prize);
    }

    @Override
    public String toString() {
        return result.entrySet().stream()
            .map(it -> it.getKey() + it.getValue().toString() + "\n")
            .collect(Collectors.joining());
    }
}
