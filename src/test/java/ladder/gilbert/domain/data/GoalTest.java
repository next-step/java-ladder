package ladder.gilbert.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoalTest {


    @Test
    void formatted() {
        Goal a = new Goal("a");
        assertThat(a.formatted()).isEqualTo("     a");
    }
}
