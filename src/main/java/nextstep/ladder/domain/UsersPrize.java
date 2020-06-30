package nextstep.ladder.domain;

import nextstep.ladder.domain.tobe.Ladder;
import nextstep.ladder.domain.tobe.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class UsersPrize {
    private final Map<String, Prize> prizeMap;

    public UsersPrize(Users users, Prizes prizes, Ladder ladder) {
        this.prizeMap = new HashMap<>();
        IntStream
                .range(0, users.size())
                .forEach(i -> {
                    int lastPosition = ladder.getLastPosition(new Point(i));
                    add(users.getUser(i), prizes.getPrice(lastPosition));
                });
    }

    private void add(User user, Prize prize) {
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
