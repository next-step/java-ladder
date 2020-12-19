package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {

    private static final String ALL_USER_KEY = "all";
    private LadderGoals ladderGoals;
    private List<LadderRow> ladderRows;

    public Ladder(Users users, LadderHeight height, LadderGoals ladderGoals, DirectionStrategy directionStrategy) {
        throwIfNull(users, ladderGoals);
        throwIfInvalidLadderGame(users, ladderGoals);
        this.ladderGoals = ladderGoals;
        this.ladderRows = IntStream.range(0, height.getValue())
                .boxed()
                .map(index -> new LadderRow(users, directionStrategy))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private void throwIfNull(Users users, LadderGoals ladderGoals) {
        if (users == null || ladderGoals == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }

    private void throwIfInvalidLadderGame(Users users, LadderGoals ladderGoals) {
        if (users.size() != ladderGoals.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }

    public List<LadderRow> getLadderRows() {
        return this.ladderRows;
    }

    public LadderGoal move(int index) {
        int curIndex = index;
        for (LadderRow ladderRow : ladderRows) {
            curIndex = ladderRow.move(curIndex);
        }
        return ladderGoals.get(curIndex);
    }

    public List<LadderResult> start(String key, Users users) {
        if (ALL_USER_KEY.equals(key)) {
            return users.export()
                    .stream()
                    .map(this::moveUser)
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(moveUser(users.getUser(key)));
    }

    private LadderResult moveUser(User user) {
        int userIndex = user.getIndex();
        LadderGoal ladderGoal = move(userIndex);
        return new LadderResult(user, ladderGoal);
    }
}

