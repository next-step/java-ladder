package ladder.domain.ladder;

import ladder.domain.LadderGameResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Ladder2Test {
    private static final Logger log = LoggerFactory.getLogger(Ladder2Test.class);

    @Test
    public void 최종_index_가져오기() {
        // given
        Line2 topLine = new Line2(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line2 bottomLine = new Line2(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Lines2 lines = new Lines2(Arrays.asList(topLine, bottomLine));

        Ladder2 ladder = new Ladder2(lines);

        // when
        int shouldBeTwo = ladder.getResult(0);
        int shouldBeZero = ladder.getResult(1);
        int shouldBeOne = ladder.getResult(2);

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
        Line2 topLine = new Line2(Arrays.asList(newPoint(0, false, true), newPoint(1, true, false), newPoint(2, false, false)));
        Line2 bottomLine = new Line2(Arrays.asList(newPoint(0, false, false), newPoint(1, false, true), newPoint(2, true, false)));
        Lines2 lines = new Lines2(Arrays.asList(topLine, bottomLine));

        // when
        Ladder2 ladder = new Ladder2(lines);

        // then
        assertThat(ladder.toString())
                .containsSubsequence(
                        "|-----|     |",
                        "|     |-----|");

        log.debug("ladden\n{}", ladder);
    }

    private Point2 newPoint(int index, boolean left, boolean right) {
        Direction direction = new Direction(left, right);
        return new Point2(index, direction);
    }
}
