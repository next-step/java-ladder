package ladder.domain;

import ladder.domain.type.ActionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private ActionType leftType;
    private ActionType rightType;
    private ActionType downType;

    @BeforeEach
    void setUp() {
        leftType = ActionType.LEFT;
        rightType = ActionType.RIGHT;
        downType = ActionType.DOWN;
    }

    @Test
    void listOf() {
        List<Line> lines = Line.listOf(3, 5);

        assertThat(lines).hasSize(5);
        assertThat(lines.get(0).getActionsSize()).isEqualTo(3);
    }

    @Test
    void getActionsSize() {
        Line line = new Line(Arrays.asList(ActionType.RIGHT, ActionType.LEFT, ActionType.DOWN));

        int actual = line.getActionsSize();

        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:-1", "2:0", "3:1", "4:-1"}, delimiter = ':')
    void getMovePoint(int value, int expected) {
        Line line = new Line(Arrays.asList(rightType, leftType, downType, rightType, leftType));

        int actual = line.getMovePoint(value);

        assertThat(actual).isEqualTo(expected);
    }
}
