package ladder.domain;

import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static ladder.domain.Line.MIN_WIDTH;
import static ladder.domain.Ladder.MIN_HEIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderTest {

    @Test
    void 생성검증() {
        Assertions.assertThat(Ladder.of(4, 5)).isInstanceOf(Ladder.class);
    }

    @Test
    void 높이검증() {
        assertThatThrownBy(() -> {
            Ladder ladder = Ladder.of(1, 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }

    @Test
    void 넓이검증() {
        assertThatThrownBy(() -> {
            Ladder ladder = Ladder.of(2, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value={"0, 3", "1, 1", "2, 2", "3, 0"})
    void 최종이동검증(int first, int last) {
        Line line1 = new Line(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));
        Line line2 = new Line(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT, Direction.NONE));
        Line line3 = new Line(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));

        Ladder ladder = Ladder.of(Arrays.asList(line1, line2, line3));

        Assertions.assertThat(ladder.getLastPosition(first)).isEqualTo(last);
    }
}
