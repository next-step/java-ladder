package ladder.domain.ladder;

import ladder.domain.ladder.generator.StayDirectionGenerator;
import ladder.vo.LadderLocation;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class Lines2Test {
    private static final Logger log = LoggerFactory.getLogger(Lines2Test.class);

    @Test
    public void Line_들의_size가_전부_일치하지_않는_경우_IllegalArgumentException() {
        // given
        StayDirectionGenerator directionGenerator = new StayDirectionGenerator();
        Line2 two = Line2.init(2, directionGenerator);
        Line2 three = Line2.init(3, directionGenerator);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lines2(Arrays.asList(two, three)));
    }

    @Test
    public void 다음_Line으로_건너가기() {
        // given
        Line2 topLine = new Line2(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line2 bottomLine = new Line2(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Lines2 lines = new Lines2(Arrays.asList(topLine, bottomLine));

        // when
        LadderLocation shouldBeSecond = lines.cross(new LadderLocation(0, 2));
        LadderLocation shouldBeFirst = lines.cross(new LadderLocation(1, 2));
        LadderLocation shouldBeThird = lines.cross(new LadderLocation(2, 2));

        // then
        assertThat(shouldBeSecond).isEqualTo(new LadderLocation(1,1));
        assertThat(shouldBeFirst).isEqualTo(new LadderLocation(0, 1));
        assertThat(shouldBeThird).isEqualTo(new LadderLocation(2, 1));

        log.debug("lines\n{}", lines);
    }

    @Test
    public void view에_보이는_String_테스트() {
        // given
        Line2 topLine = new Line2(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line2 bottomLine = new Line2(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));

        // when
        Lines2 lines = new Lines2(Arrays.asList(topLine, bottomLine));

        // then
        assertThat(lines.toString())
                .containsSubsequence(
                        "|-----|     |",
                        "|     |-----|");

        log.debug("lines\n{}", lines);
    }

    private Point2 newPoint(int index, boolean left, boolean right) {
        Direction direction = new Direction(left, right);
        return new Point2(index, direction);
    }
}
