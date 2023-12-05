package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoalsTest {


    @Test
    void get() {
        Goals goals = new Goals("a", "b", "c");
        assertThat(goals.get(0)).isEqualTo(new Goal("a"));
    }
}
