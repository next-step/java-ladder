package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String ALL_USER_KEY = "all";
    private final Users users;
    private final Ladder ladder;
    private final LadderGoalBoard ladderGoalBoard;

    public LadderGoalBoard getLadderGoalBoard() {
        return ladderGoalBoard;
    }

    public LadderGame(Users users, LadderHeight height, LadderGoalBoard ladderGoalBoard) {
        throwIfNull(users, ladderGoalBoard);
        throwIfInvalidLadderGame(users, ladderGoalBoard);
        this.users = users;
        this.ladder = new Ladder(users, height);
        this.ladderGoalBoard = ladderGoalBoard;
    }

    private void throwIfNull(Users users, LadderGoalBoard ladderGoalBoard) {
        if (users == null || ladderGoalBoard == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }

    private void throwIfInvalidLadderGame(Users users, LadderGoalBoard ladderGoalBoard) {
        if (users.size() != ladderGoalBoard.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }

    public List<LadderResult> start(String key) {
        if (ALL_USER_KEY.equals(key)) {
            return users.export()
                    .stream()
                    .map(this::moveUser)
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(moveUser(new User(key)));
    }

    private LadderResult moveUser(User user) {
        int userIndex = users.indexOf(user);
        int resultIndex = ladder.move(userIndex);
        LadderGoal ladderGoal = ladderGoalBoard.get(resultIndex);
        return new LadderResult(user, ladderGoal);
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
