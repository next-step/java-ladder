package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new TestLinesGenerator(), 5, 5);
    }

    @DisplayName("TestLinesGenerator 클래스는 각 행별로 width - 1, width 에 해당하는 라인을 생성한다. " +
            "즉 위에 ladder 클래스로는 3열과 4열에 해당하는 라인이 각 행마다 존재해야한다.")
    @Test
    void 생성_라인_검증() {
        assertAll(
                () -> assertThat(
                        ladder.hasLine(new Line(new Position(3, 0), new Position(4, 0)), 0)
                ).isTrue(),
                () -> assertThat(
                        ladder.hasLine(new Line(new Position(3, 1), new Position(4, 1)), 1)
                ).isTrue(),
                () -> assertThat(
                        ladder.hasLine(new Line(new Position(3, 2), new Position(4, 2)), 2)
                ).isTrue(),
                () -> assertThat(
                        ladder.hasLine(new Line(new Position(3, 3), new Position(4, 3)), 3)
                ).isTrue(),
                () -> assertThat(
                        ladder.hasLine(new Line(new Position(3, 4), new Position(4, 4)), 4)
                ).isTrue()
        );
    }

    @ParameterizedTest(name = "사다리는 파라미터로 전달된 height 만큼 높이가 생성되 있어야 한다.")
    @CsvSource(value = {
            "3|3",
            "4|4",
            "5|5",
            "6|6",
    }, delimiter = '|')
    void 높이_검증(int width, int height) {
        assertThat(new Ladder(new TestLinesGenerator(), width, height).height()).isEqualTo(height);
    }

}