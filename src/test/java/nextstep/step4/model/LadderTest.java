package nextstep.step4.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    /**
     * |-----|     |
     */
    @Test
    void create() {
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(), Point.first(true).next().last());
        Line line = new Line(points);

        Ladder ladder = new Ladder(2, List.of(line));
        assertThat(ladder).isEqualTo(new Ladder(2, List.of(line)));
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 라인정보가_비어있는경우_예외를_던진다(List<Line> lines) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(2, lines));
    }

    /**
     * |     |     |
     * |     |     |
     */
    @Test
    void 사다리라인이_직선인_경우() {
        Line line = new Line(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last()));
        Line line2 = new Line(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last()));

        Ladder ladder = new Ladder(3, List.of(line, line2));
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult).isEqualTo(new LadderResult(Map.of(0, 0, 1, 1, 2, 2)));
    }

    /**
     * |-----|     |
     * |     |-----|
     */
    @Test
    void 사다리라인이_연결되어_있는경우() {
        Line line = new Line(Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last()));
        Line line2 = new Line(Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last()));

        Ladder ladder = new Ladder(3, List.of(line, line2));
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult).isEqualTo(new LadderResult(Map.of(0, 2, 1, 0, 2, 1)));
    }
}
