package ladder.domain.ladder;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    public void Line의_Point가_하나일_경우_IllegalArgumentException() {
        // (참가자가 한 명일 경우)
        // given
        Point point = Point.LEFT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point)));
    }

    @Test
    public void 가장_왼쪽의_Point가_왼쪽으로_건너갈_수_있는_경우_IllegalArgumentException() {
        // given
        Point point = Point.LEFT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point, point)));
    }

    @Test
    public void 가장_오른쪽의_Point가_오른쪽으로_건너갈_수_있는_경우_IllegalArgumentException() {
        // given
        Point point = Point.RIGHT_CROSS_POINT;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(point, point)));
    }

    @Test
    public void 인접한_Point_끼리_Cross가_일치하지_않는_경우_IllegalArgumentException() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Line(Arrays.asList(Point.RIGHT_CROSS_POINT, Point.LEFT_CROSS_POINT, Point.LEFT_CROSS_POINT)));
    }
}
