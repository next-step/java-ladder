package ladder.domain;

import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static ladder.domain.JerryLadderCreator.MIN_HEIGHT;
import static ladder.domain.JerryLineCreator.MIN_WIDTH;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class JerryLadderTest {

    @Test
    void 생성검증() {
        Assertions.assertThat(JerryLadder.of(4, 5)).isInstanceOf(JerryLadder.class);
    }

    @Test
    void 높이검증() {
        assertThatThrownBy(() -> {
            JerryLadder ladder = JerryLadder.of(1, 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }

    @Test
    void 넓이검증() {
        assertThatThrownBy(() -> {
            JerryLadder ladder = JerryLadder.of(2, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value={"0, 3", "1, 1", "2, 2", "3, 0"})
    void 최종이동검증(int first, int last) {
        JerryLine line1 = new JerryLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));
        JerryLine line2 = new JerryLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE));
        JerryLine line3 = new JerryLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));

        JerryLadder ladder = JerryLadder.of(Arrays.asList(line1, line2, line3));

        Assertions.assertThat(ladder.getLastPosition(first)).isEqualTo(last);
    }
}
