package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static domain.DirectionTest.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderLineTest {
    public static LadderLine FIRST_LINE = new LadderLine(Arrays.asList(
            new Point(0, RIGHT_DIRECTION),
            new Point(1, LEFT_DIRECTION),
            new Point(2, NO_DIRECTION)));
    public static LadderLine SECOND_LINE = new LadderLine(Arrays.asList(
            new Point(0, NO_DIRECTION),
            new Point(1, RIGHT_DIRECTION),
            new Point(2, LEFT_DIRECTION)));
    public static LadderLine THIRD_LINE = new LadderLine(Arrays.asList(
            new Point(0, NO_DIRECTION),
            new Point(1, NO_DIRECTION),
            new Point(2, NO_DIRECTION)));

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        assertThat(FIRST_LINE.move(0)).isEqualTo(1);
        assertThat(FIRST_LINE.move(1)).isEqualTo(0);
        assertThat(FIRST_LINE.move(2)).isEqualTo(2);
        assertThat(SECOND_LINE.move(0)).isEqualTo(0);
        assertThat(SECOND_LINE.move(1)).isEqualTo(2);
        assertThat(SECOND_LINE.move(2)).isEqualTo(1);
        assertThat(THIRD_LINE.move(0)).isEqualTo(0);
        assertThat(THIRD_LINE.move(1)).isEqualTo(1);
        assertThat(THIRD_LINE.move(2)).isEqualTo(2);
    }
}
