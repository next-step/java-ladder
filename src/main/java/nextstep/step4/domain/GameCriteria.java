package nextstep.step4.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameCriteria {

    private final Users users;
    private final Results results;

    private GameCriteria(Users users, Results results) {
        this.users = users;
        this.results = results;
    }

    public static GameCriteria of(Users users, Results results) {
        return new GameCriteria(users, results);
    }

    public Map<String, Result> mapUsernameResult(Ladder ladder) {
        return users.getUserList().stream()
                .collect(Collectors.toMap(User::toString,
                        getUserResult(ladder),
                        (participant1, participant2) -> participant1,
                        LinkedHashMap::new));
    }

    private Function<User, Result> getUserResult(Ladder ladder) {
        return user -> {
            int finalIndex = ladder.getUserFinalIndex(user);
            return results.confirmResult(finalIndex);
        };
    }

    public List<User> getUserList() {
        return users.getUserList();
    }

    public List<Result> getResultList() {
        return results.getResultList();
    }

    public int getUserNumbers() {
        return users.getUserNumbers();
    }

}
