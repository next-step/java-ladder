package nextstep.ladder.domain.result;


import nextstep.ladder.domain.user.User;

import java.util.*;

public class LadderResult {

    private Map<User, Integer> ladderResult;

    public LadderResult(List<User> users) {
        this.ladderResult = initMap(users);
    }

    private Map<User, Integer> initMap(List<User> users) {
        ladderResult = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            ladderResult.put(user, i);
        }
        return ladderResult;
    }

    public Map<User, Integer> getLadderResult() {
        return ladderResult;
    }

}
