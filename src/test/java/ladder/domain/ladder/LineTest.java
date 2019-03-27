package ladder.domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    public void 가로가_겹치는_경우_IllegalArgumentException() {
        // given
        Point cross = Point.CROSS;
        Point notCross = Point.NOT_CROSS;

        // when
        List<Point> points = Arrays.asList(notCross, cross, cross);

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(points));
    }
}
