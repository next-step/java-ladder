package ladder.domain;


import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ladder.domain.Line.MIN_WIDTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LineTest {
    @Test
    void 생성검증() {
        Assertions.assertThat(Line.createLineWithWidth(4)).isInstanceOf(Line.class);
    }

    @Test
    void width검증() {
        assertThatThrownBy(() -> {
            Assertions.assertThat(Line.createLineWithWidth(1));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value={"0, 1", "1, 0", "2, 2"})
    void 이동검증(int current, int next) {
        Line line = new Line(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE));

        Assertions.assertThat(line.getNextPosition(current)).isEqualTo(next);
    }
}
