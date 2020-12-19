package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {

    private List<LadderRow> ladderRows;

    public Ladder(Users users, LadderHeight height, DirectionStrategy directionStrategy) {
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

    public int move(int index) {
        int curIndex = index;
        for (LadderRow ladderRow : ladderRows) {
            curIndex = ladderRow.move(curIndex);
        }
        return curIndex;
    }

    public LadderResults start(Users users, LadderGoals ladderGoals) {
        throwIfNull(users, ladderGoals);
        throwIfInvalidLadderGame(users, ladderGoals);
        List<LadderResult> list = new ArrayList<>();
        for (User user : users.export()) {
            int index = user.getIndex();
            int move = move(index);
            list.add(new LadderResult(user, ladderGoals.get(move)));
        }
        return new LadderResults(list);
    }

}

