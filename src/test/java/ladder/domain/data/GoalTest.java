package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoalTest {


    @Test
    void addIndent() {
        Goal a = new Goal("a");
        assertThat(a.addIndent()).isEqualTo("     a");
    }
}
