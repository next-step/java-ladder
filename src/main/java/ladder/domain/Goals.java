package ladder.domain;

import java.util.List;
import java.util.Objects;

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

    public List<String> goals() {
        return goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goals goals1 = (Goals) o;
        return Objects.equals(goals, goals1.goals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goals);
    }

    private void verifyGoals(List<String> goals, int numberOfPlayers) {
        if (goals.size() != numberOfPlayers) {
            throw new IllegalArgumentException("실행 결과 수는 참여자 수와 같아야 합니다");
        }
    }
}
