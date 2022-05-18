package ladder.domain.ladder;

import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static ladder.domain.ladder.LineTest.LEFT_LINE;
import static ladder.domain.ladder.LineTest.RIGHT_LINE;
import static ladder.domain.ladder.LineTest.UNCONNECTED_LINE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LadderTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Ladder는_lines_없이_생성_할_경우_예외를_발생_시킨다(List<Line> lines) {
        assertThatThrownBy(
                () -> new Ladder(lines)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidthAndHeight는_width와_height로_Ladder를_생성한다() {
        int width = 4;
        int height = 5;

        Ladder ladder = Ladder.generateByWidthAndHeight(width, height);

        assertInstanceOf(Ladder.class, ladder);
    }

    @Test
    void trace는_position을_사다리를_따라서_이동된_위치를_반환한다() {
        Position position = new Position(2);
        Ladder ladder = new Ladder(List.of(
                RIGHT_LINE,
                UNCONNECTED_LINE,
                LEFT_LINE,
                LEFT_LINE
        ));

        Position movedPosition = ladder.trace(position);

        assertEquals(movedPosition, new Position(1));
    }
}
