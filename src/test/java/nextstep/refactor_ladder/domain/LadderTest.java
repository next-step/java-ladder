package nextstep.refactor_ladder.domain;

import nextstep.refactor_ladder.domain.value.Direction;
import nextstep.refactor_ladder.domain.value.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    private List<Line> lines;

    /**
     * 0     1     2     3
     * |     |-----|     |
     * |-----|     |-----|
     * |     |     |-----|
     * |-----|     |     |
     * 0     1     2     3
     */
    @BeforeEach
    void setup() {
        Line line1 = Line.from(
                Arrays.asList(Point.of(0, Direction.of(false, false)),
                              Point.of(1, Direction.of(false, true)),
                              Point.of(2, Direction.of(true, false)),
                              Point.of(3, Direction.of(false, false))));

        Line line2 = Line.from(
                Arrays.asList(Point.of(0, Direction.of(false, true)),
                              Point.of(1, Direction.of(true, false)),
                              Point.of(2, Direction.of(false, true)),
                              Point.of(3, Direction.of(true, false))));


        Line line3 = Line.from(
                Arrays.asList(Point.of(0, Direction.of(false, false)),
                              Point.of(1, Direction.of(false, false)),
                              Point.of(2, Direction.of(false, true)),
                              Point.of(3, Direction.of(true, false))));

        Line line4 = Line.from(
                Arrays.asList(Point.of(0, Direction.of(false, true)),
                              Point.of(1, Direction.of(true, false)),
                              Point.of(2, Direction.of(false, false)),
                              Point.of(3, Direction.of(false, false))));

        lines = Arrays.asList(line1, line2, line3, line4);
    }

    @Test
    @DisplayName("사다리 정상 생성 검증")
    void create() {
        assertDoesNotThrow(
                () -> Ladder.from(lines));
    }

    @Test
    @DisplayName("라인 정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(Collections.emptyList()));
            assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(null));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0      |0",
            "1      |2",
            "2      |1",
            "3      |3"
    }, delimiter = '|')
    @DisplayName("사다리 이동 검증")
    void move(int currentIndex, int lastIndex) {
        // given
        Ladder ladder = Ladder.from(lines);

        // when
        int index = ladder.move(currentIndex);

        // then
        assertThat(index).isEqualTo(lastIndex);
    }
}
