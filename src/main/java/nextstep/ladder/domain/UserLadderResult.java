package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserLadderResult {

    HashMap<User, Result> resultHashMap = new HashMap<>();

    public UserLadderResult(List<User> users, List<Result> results) {
        users.stream().forEach(user -> resultHashMap.put(user, user.findUserResult(results)));
    }

    public Result findUserResult(String name) {
        User findUser = resultHashMap.keySet().stream()
                .filter(user -> user.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return resultHashMap.get(findUser);
    }

    public Set<User> findAllUser() {
        return resultHashMap.keySet();
    }
}
