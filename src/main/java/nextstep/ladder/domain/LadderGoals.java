package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderGoals {

    private static final String COMMA = ",";
    private final List<LadderGoal> ladderGoals;

    public LadderGoals(String ladderGoalString) {
        this.ladderGoals = Arrays.stream(ladderGoalString.split(COMMA))
                .map(LadderGoal::new)
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int size() {
        return this.ladderGoals.size();
    }

    public List<LadderGoal> export() {
        return this.ladderGoals;
    }

    public LadderGoal get(int index) {
        return ladderGoals.get(index);
    }
}
