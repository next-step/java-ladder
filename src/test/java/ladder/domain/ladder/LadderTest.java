package ladder.domain.ladder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final Logger log = LoggerFactory.getLogger(LadderTest.class);

    @Test
    public void 최종_index_가져오기() {
        // given
        Line topLine = new Line(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line bottomLine = new Line(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Lines lines = new Lines(Arrays.asList(topLine, bottomLine));

        Ladder ladder = new Ladder(lines);

        // when
        int shouldBeTwo = ladder.getResultIndex(0);
        int shouldBeZero = ladder.getResultIndex(1);
        int shouldBeOne = ladder.getResultIndex(2);

        // then
        assertThat(shouldBeZero).isEqualTo(0);
        assertThat(shouldBeOne).isEqualTo(1);
        assertThat(shouldBeTwo).isEqualTo(2);

        log.debug("ladden\n{}", ladder);
    }

    @Test
    public void view에_보이는_String_테스트() {
        // given
        // given
        Line topLine = new Line(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line bottomLine = new Line(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Lines lines = new Lines(Arrays.asList(topLine, bottomLine));

        // when
        Ladder ladder = new Ladder(lines);

        // then
        assertThat(ladder.toString())
                .containsSubsequence(
                        "|-----|     |",
                        "|     |-----|");

        log.debug("ladden\n{}", ladder);
    }

    private Point newPoint(int index, boolean left, boolean right) {
        Direction direction = new Direction(left, right);
        return new Point(index, direction);
    }
}
