package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.Objects;

public class LadderGame {

    private final Ladder ladder;
    private final Results results;

    public LadderGame(Ladder ladder, Results results) {
        if (Objects.isNull(ladder) || Objects.isNull(results)) {
            throw new IllegalArgumentException("inject null from LadderGame class");
        }
        this.ladder = ladder;
        this.results = results;
    }

    public LadderGameResult play(List<User> users) {
        validateUsers(users);

        return null;
    }

    private void validateUsers(List<User> users) {
        if (Objects.isNull(users)) {
            throw new IllegalArgumentException("play user list is null");
        }
        users.stream().map(User::getOrder)
                .forEach(this::validateStartOrder);
    }

    private void validateStartOrder(Order order) {
        if (!order.isEqualsOrLessThanMaxPosition(ladder.getMaxPosition())) {
            throw new IllegalArgumentException("user order is not less than max position");
        }
    }
}
