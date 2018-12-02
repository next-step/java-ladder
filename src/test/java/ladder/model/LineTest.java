package ladder.model;

import org.junit.Test;

import java.util.Arrays;

import static ladder.model.ArrowTest.BOTTOM_ARROW;
import static ladder.model.ArrowTest.LEFT_ARROW;
import static ladder.model.ArrowTest.RIGHT_ARROW;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    public static final Line DEFAULT_LINE = Line.from(Arrays.asList(
            Point.from(0, BOTTOM_ARROW),
            Point.from(1, RIGHT_ARROW),
            Point.from(2, LEFT_ARROW),
            Point.from(3, BOTTOM_ARROW)));

    @Test
    public void 생성() {
        assertThat(Line.from(5)).isNotNull();
    }

    @Test
    public void 생성_참가자_수_5명_일때_포인트_수() {
        assertThat(Line.from(5).getPoints().size()).isEqualTo(5);
    }

}