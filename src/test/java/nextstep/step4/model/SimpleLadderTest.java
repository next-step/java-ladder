package nextstep.step4.model;

import nextstep.step4.api.Ladder;
import nextstep.step4.api.LadderResult;
import nextstep.step4.api.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SimpleLadderTest {
    /**
     * |-----|     |
     */
    @Test
    void create() {
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(), Point.first(true).next().last());
        Line line = new SimpleLine(points);

        Ladder ladder = new SimpleLadder(2, List.of(line));
        assertThat(ladder).isEqualTo(new SimpleLadder(2, List.of(line)));
    }

    @Test
    void 라인정보가_비어있는경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SimpleLine(null));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SimpleLine(Collections.emptyList()));
    }

    /**
     * |     |     |
     * |     |     |
     */
    @Test
    void 사다리라인이_직선인_경우() {
        Line line = new SimpleLine(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last()));
        Line line2 = new SimpleLine(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last()));

        Ladder ladder = new SimpleLadder(3, List.of(line, line2));
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult).isEqualTo(new LadderResult(Map.of(0, 0, 1, 1, 2, 2)));
    }

    /**
     * |-----|     |
     * |     |-----|
     */
    @Test
    void 사다리라인이_연결되어_있는경우() {
        Line line = new SimpleLine(Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last()));
        Line line2 = new SimpleLine(Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last()));

        Ladder ladder = new SimpleLadder(3, List.of(line, line2));
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult).isEqualTo(new LadderResult(Map.of(0, 2, 1, 0, 2, 1)));
    }
}
