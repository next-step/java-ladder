package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    public LadderGame(Users users, LadderHeight ladderHeight) {
        this.users = users;
        this.ladder = new Ladder(this.users.getUsersSize(), ladderHeight.getHeight());
    }

    public LadderGameResult play(LadderRewards ladderRewards) {
        Map<User, Reward> rewardsOfUsers = new HashMap<>();

        getUnmodifiableLadderLines().forEach(this::iterateLines);

        for (int i = 0; i < users.getUsersSize(); i++) {
            rewardsOfUsers.put(users.userByIndex(i), ladderRewards.rewardByIndex(i));
        }

        return new LadderGameResult(rewardsOfUsers);
    }

    private void iterateLines(Line ladderLine) {
        ladderLine.getUnmodifiableListPoints().forEach(this::swapUsers);
    }

    private void swapUsers(Point point) {
        if (point.canMovePrevious()) {
            users.userSwap(point.currentPreviousUserPosition(), point.currentUserPosition());
        }
    }

    public List<User> getUnmodifiableUsers() {
        return users.unmodifiableUsers();
    }

    public List<Line> getUnmodifiableLadderLines() {
        return ladder.getUnmodifiableLadderLines();
    }
}
