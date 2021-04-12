package ladder.domain;

import java.util.List;

public class Goals {
    private final List<String> goals;

    public Goals(List<String> goals) {
        this(goals, goals.size());
    }

    public Goals(List<String> goals, int numberOfPlayers) {
        verifyGoals(goals, numberOfPlayers);
        this.goals = goals;
    }

    public String item(int index) {
        return goals.get(index);
    }

    private void verifyGoals(List<String> goals, int numberOfPlayers) {
        if (goals.size() != numberOfPlayers) {
            throw new IllegalArgumentException("실행 결과 수는 참여자 수와 같아야 합니다");
        }
    }
}
