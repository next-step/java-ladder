package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LadderTest {
    @Test
    void Ladder는_rows_없이_생성할_경우_예외를_발생시킨다() {
        assertThatThrownBy(
                () -> new Ladder(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidthAndHeight는_width와_height로_Ladder를_생성한다() {
        int width = 4;
        int height = 5;

        Ladder ladder = Ladder.generateByWidthAndHeight(width, height);

        assertAll(
                () -> assertInstanceOf(Ladder.class, ladder)
        );
    }
}
