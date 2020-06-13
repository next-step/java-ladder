package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.Objects;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        if (Objects.isNull(ladder)) {
            throw new IllegalArgumentException("Ladder is null.");
        }
        this.ladder = ladder;
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
                .forEach(this::validateOrder);
    }

    private void validateOrder(Order order) {
        if (!order.isEqualsOrLessThanMaxPosition(ladder.getMaxPosition())) {
            throw new IllegalArgumentException("user order is not less than max position");
        }
    }
}
