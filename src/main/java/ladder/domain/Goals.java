package ladder.domain;

import ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Goals {

    private static final String RESULTS_DELIMITER = ",";
    private List<Goal> goals;

    public Goals(String goal) {

        if (StringUtils.isBlank(goal)) {
            throw new IllegalArgumentException("실행결과가 빈 값입니다.");
        }

        this.goals = StringUtils.split(goal, RESULTS_DELIMITER)
                .stream()
                .map(Goal::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return goals.size();
    }

    public List<Goal> getGoals() {

        return Collections.unmodifiableList(goals);
    }

    public Goal getGoal(int index) {

        return goals.get(index);
    }
}
