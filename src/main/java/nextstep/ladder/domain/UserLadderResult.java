package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class UserLadderResult {

    private HashMap<User, Result> resultHashMap = new LinkedHashMap<>();

    public UserLadderResult(List<User> users, List<Result> results) {
        users.stream().forEach(user -> resultHashMap.put(user, user.findUserResult(results)));
    }

    public Result findUserResult(String name) {
        Result result = resultHashMap.entrySet().stream()
                .filter(e -> e.getKey().equals(new User(name)))
                .findFirst()
                .map(e -> e.getValue())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return result;
    }

    public Set<User> findAllUser() {
        return resultHashMap.keySet();
    }
}
