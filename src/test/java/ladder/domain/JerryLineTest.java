package ladder.domain;


import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


import static ladder.domain.JerryLineCreator.MIN_WIDTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class JerryLineTest {
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value={"0, 1", "1, 0", "2, 2"})
    void 이동검증(int current, int next) {
        JerryLine line = new JerryLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE));

        Assertions.assertThat(line.getNextPosition(current)).isEqualTo(next);
    }
}
