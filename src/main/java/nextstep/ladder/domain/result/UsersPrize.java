package nextstep.ladder.domain.result;

import nextstep.ladder.domain.ladders.Ladder;
import nextstep.ladder.domain.prizes.Prize;
import nextstep.ladder.domain.prizes.Prizes;
import nextstep.ladder.domain.users.User;
import nextstep.ladder.domain.users.Users;

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
