package ladder.domain;

import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class JerryLadderTest {

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"0, 3", "1, 1", "2, 2", "3, 0"})
    void 최종이동검증(int first, int last) {
        JerryLine line1 = new JerryLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));
        JerryLine line2 = new JerryLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE));
        JerryLine line3 = new JerryLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));

        JerryLadder ladder = new JerryLadder(Arrays.asList(line1, line2, line3));

        Assertions.assertThat(ladder.getLastPosition(first)).isEqualTo(last);
    }
}
