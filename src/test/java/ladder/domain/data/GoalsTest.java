package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoalsTest {

    @Test
    void size() {
        Goals goals = goals();
        assertThat(goals.size()).isEqualTo(3);
    }

    @Test
    void get() {
        Goals goals = goals();
        assertThat(goals.get(0)).isEqualTo(new Goal("a"));
    }

    private Goals goals() {
        return new Goals("a", "b", "c");
    }
}
