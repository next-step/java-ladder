package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderGoalBoard {

    private final String COMMA = ",";
    private final List<LadderGoal> ladderGoals;

    public LadderGoalBoard(String ladderGoalString) {
        this.ladderGoals = Arrays.stream(ladderGoalString.split(COMMA))
                .map(goal -> new LadderGoal(goal))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int size() {
        return this.ladderGoals.size();
    }
}
