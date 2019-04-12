package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;
import ladder.domain.ladder.generator.StayDirectionGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private static final Logger log = LoggerFactory.getLogger(LineTest.class);

    @Test
    public void 생성_시_사이즈가_2_미만일_경우_IllegalArgumentException() {
        // when
        // then
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        assertThatIllegalArgumentException().isThrownBy(() -> Line.init(1, directionGenerator));
    }

    @Test
    public void 첫번째_Point의_left가_true면_IllegalArgumentException() {
        // given
        Point previous = new Point(0, new Direction(true, false));
        Point next = new Point(1, new Direction(false, false));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(previous, next)));
    }

    @Test
    public void 마지막_Point의_right가_true면_IllegalArgumentException() {
        // given
        Point previous = new Point(0, new Direction(false, false));
        Point next = new Point(1, new Direction(false, true));

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(Arrays.asList(previous, next)));
    }

    @Test
    public void 생성_시_이전_Point와_다음_Point가_맞물리지_않으면_IllegalStateException() {
        // given
        Point previous = new Point(0, new Direction(false, false));
        Point next = new Point(1, new Direction(true, false));

        // when
        // then
        assertThatIllegalStateException().isThrownBy(() -> new Line(Arrays.asList(previous, next)));
    }

    @Test
    public void 정상_생성() {
        // given
        int initialSize = 2;
        DirectionGenerator directionGenerator = new StayDirectionGenerator();

        // when
        Line line = Line.init(initialSize, directionGenerator);

        // then
        assertThat(line.getSize()).isEqualTo(initialSize);

        log.debug("line\n{}", line);
    }

    @Test
    public void Line_내에서_이동() {
        // given
        Point previous = new Point(0, new Direction(false, true));
        Point next = new Point(1, new Direction(true, false));

        Line line = new Line(Arrays.asList(previous, next));

        // when
        int shouldBeOne = line.move(0);

        // then
        assertThat(shouldBeOne).isEqualTo(1);
    }

    @Test
    public void view로_보이는_String_테스트() {
        // given
        Point first = new Point(0, new Direction(false, false));
        Point middle = new Point(1, new Direction(false, true));
        Point last = new Point(2, new Direction(true, false));

        // when
        Line line = new Line(Arrays.asList(first, middle, last));

        // then
        assertThat(line.toString()).contains("|     |-----|");

        log.debug("line\n{}", line);
    }
}
