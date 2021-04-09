package ladder;

import ladder.domain.ResultElement;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultElementTest {
    @Test
    void When_New_Then_Created() {
        assertDoesNotThrow(
                () -> {
                    new ResultElement("name", "goal");
                }
        );
    }

    @Test
    void When_Goal_Then_ReturnsGoal() {
        ResultElement element = new ResultElement("name", "goal");

        assertThat(element.goal()).isEqualTo("goal");
    }
}
