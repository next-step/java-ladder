package ladder.domain.type;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionTypeTest {
    @Test
    void listOf() {
        int userCount = 3;

        List<ActionType> actionTypes = ActionType.listOf(userCount);

        assertThat(actionTypes).hasSize(userCount);
    }
}

