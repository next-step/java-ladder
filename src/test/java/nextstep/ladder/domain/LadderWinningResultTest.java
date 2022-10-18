package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderWinningResultTest {

    private Ladder ladder;

    /**
     *  테스트를 위해 아래 사다리를 이용한다.
     *
     *     0     1     2     3
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |-----|
     *    꽝    5000   꽝   3000
     */
    @BeforeEach
    void setUp() {
        final Point first = Point.first(true);
        final List<Point> points1 = List.of(first
                , first.next(false)
                , first.next(false).next(true)
                , first.next(false).next(true).next(false)
        );
        final Point first2 = Point.first(false);
        final List<Point> points2 = List.of(first2
                , first2.next(true)
                , first2.next(true).next(false)
                , first2.next(true).next(false).next(false)
        );
        final Point first3 = Point.first(true);
        final List<Point> points3 = List.of(first3
                , first3.next(false)
                , first3.next(false).next(true)
                , first3.next(false).next(true).next(false)
        );
        ladder = new Ladder(List.of(new Line(points1), new Line(points2), new Line(points3)));
    }

    @DisplayName("사다리의 순서를 확인한다.")
    @Test
    void result_findByName() {

        final LadderWinningResult ladderWinningResult = LadderWinningResult.of(ladder);

        assertAll(
                () -> assertThat(ladderWinningResult.findByName(0)).isEqualTo(3),
                () -> assertThat(ladderWinningResult.findByName(1)).isEqualTo(1),
                () -> assertThat(ladderWinningResult.findByName(2)).isEqualTo(2),
                () -> assertThat(ladderWinningResult.findByName(3)).isEqualTo(0)
        );
    }
}