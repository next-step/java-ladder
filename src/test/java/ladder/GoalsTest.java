package ladder;

import ladder.domain.Goals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GoalsTest {
    @Test
    void When_New_Then_InstanceCreated() {
        Goals goals = new Goals(Arrays.asList("a", "b", "c"));

        assertThat(goals).isEqualTo(new Goals(Arrays.asList("a", "b", "c")));
    }

    @Test
    void Given_InsufficientInput_When_New_Then_Exception() {
        int numberOfPlayers = 4;
        List<String> items = Arrays.asList("1", "2", "3");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Goals(items, numberOfPlayers));
    }

    @Test
    void When_Item_Then_Value() {
        Goals goals = new Goals(Arrays.asList("a", "b", "c"));

        assertThat(goals.item(0)).isEqualTo("a");
    }
}
