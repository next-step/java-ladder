package ladder.domain.ladder;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LinesTest {

    @Test
    public void Line_들의_size가_전부_일치하지_않는_경우_IllegalArgumentException() {
        // given
        Point point = new Point(Cross.NOT_CROSS, Cross.NOT_CROSS);
        Line two = new Line(Arrays.asList(point, point));
        Line three = new Line(Arrays.asList(point, point, point));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lines(Arrays.asList(two, two, three)));
    }
}
