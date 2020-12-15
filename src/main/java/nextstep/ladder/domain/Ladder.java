package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {

    private LadderGoalBoard ladderGoalBoard;
    private List<LadderRow> ladderRows;

    public Ladder(Users users, LadderHeight height, LadderGoalBoard ladderGoalBoard) {
        this.ladderGoalBoard = ladderGoalBoard;
        this.ladderRows = IntStream.range(0, height.getValue())
                .boxed()
                .map(index -> new LadderRow(users.size()))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<LadderRow> getLadderRows() {
        return this.ladderRows;
    }

    public LadderGoal move(int index) {
        int curIndex = index;
        for (LadderRow ladderRow : ladderRows) {
            curIndex = ladderRow.move(curIndex);
        }
        return ladderGoalBoard.get(curIndex);
    }

    public LadderGoalBoard getLadderGoalBoard() {
        return ladderGoalBoard;
    }
}
