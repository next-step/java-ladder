package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;

public class UserLadderResult {

    HashMap<User, Result> resultHashMap = new HashMap<>();

    public UserLadderResult(List<User> users, List<Result> results) {
        users.stream().forEach(user -> resultHashMap.put(user, user.findUserResult(results)));
    }

  
}
