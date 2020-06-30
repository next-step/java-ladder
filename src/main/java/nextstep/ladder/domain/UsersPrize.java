package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class UsersPrize {
    private final Map<String, Prize> prizeMap;

    public UsersPrize() {
        this.prizeMap = new HashMap<>();
    }

    public void add(User user, Prize prize) {
        prizeMap.put(user.getName(), prize);
    }

    public String getPrize(String userName) {
        if (!prizeMap.containsKey(userName)) {
            throw new NotFoundUserException("userName is not found");
        }
        return prizeMap.get(userName).getPrize();
    }

    public Map<String, Prize> getPrizeMap() {
        return prizeMap;
    }
}
