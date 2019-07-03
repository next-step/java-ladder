package ladder.domain;

import ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Goals {

    private static final String RESULTS_DELIMITER = ",";
    private List<Goal> goals;

    public Goals(String goal, int participantSize) {

        if (StringUtils.isBlank(goal)) {
            throw new IllegalArgumentException("실행결과가 빈 값입니다.");
        }

        this.goals = StringUtils.split(goal, RESULTS_DELIMITER)
                .stream()
                .map(Goal::new)
                .collect(Collectors.toList());

        if (this.goals.size() != participantSize) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치하지 않습니다. 참가자 수=" + participantSize + ", 결과 수=" + this.goals.size());
        }
    }

    public List<Goal> getGoals() {

        return Collections.unmodifiableList(goals);
    }

    public Goal getGoal(int index) {

        return goals.get(index);
    }
}
