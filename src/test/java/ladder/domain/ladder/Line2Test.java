package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;
import ladder.domain.ladder.generator.StayDirectionGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class Line2Test {
    private static final Logger log = LoggerFactory.getLogger(Line2Test.class);

    @Test
    public void 생성_시_사이즈가_2_미만일_경우_IllegalArgumentException() {
        // when
        // then
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        assertThatIllegalArgumentException().isThrownBy(() -> Line2.init(1, directionGenerator));
    }

    @Test
    public void 첫번째_Point의_left가_true면_IllegalArgumentException() {
        // given
        Point2 previous = new Point2(0, new Direction(true, false));
        Point2 next = new Point2(1, new Direction(false, false));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line2(Arrays.asList(previous, next)));
    }

    @Test
    public void 마지막_Point의_right가_true면_IllegalArgumentException() {
        // given
        Point2 previous = new Point2(0, new Direction(false, false));
        Point2 next = new Point2(1, new Direction(false, true));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line2(Arrays.asList(previous, next)));
    }

    @Test
    public void 생성_시_이전_Point와_다음_Point가_맞물리지_않으면_IllegalStateException() {
        // given
        Point2 previous = new Point2(0, new Direction(false, false));
        Point2 next = new Point2(1, new Direction(true, false));

        // when
        // then
        assertThatIllegalStateException().isThrownBy(() -> new Line2(Arrays.asList(previous, next)));
    }

    @Test
    public void 정상_생성() {
        // given
        int initialSize = 2;
        DirectionGenerator directionGenerator = new StayDirectionGenerator();

        // when
        Line2 line = Line2.init(initialSize, directionGenerator);

        // then
        assertThat(line.getSize()).isEqualTo(initialSize);

        log.debug("line\n{}", line);
    }
}
