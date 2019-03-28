package ladder.domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void Ladder_생성_시_Line들의_width_가_일치하지_않으면_IllegalArgumentException() {
        // given
        Line two = new Line(Arrays.asList(Point.CROSS, Point.NOT_CROSS));
        Line three = new Line(Arrays.asList(Point.NOT_CROSS, Point.CROSS, Point.NOT_CROSS));
        List<Line> lines = Arrays.asList(two, three, three);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(lines));
    }
}
