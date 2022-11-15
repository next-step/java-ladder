package nextstep.ladder.view;

import nextstep.ladder.codeleesh.domain.Ladder;
import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.Point;
import nextstep.ladder.codeleesh.view.LadderWinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 결과 테스트")
class LadderWinningResultTest {

    private Ladder 사다리;

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
        사다리 = new Ladder(List.of(new Line(points1), new Line(points2), new Line(points3)));
    }

    @DisplayName("사다리의 순서를 확인한다.")
    @Test
    void result_findByName() {

        final List<String> 참가자 = List.of("pobi", "honux", "crong", "jk");
        final List<String> 상품 = List.of("꽝", "5000", "꽝", "3000");
        final LadderWinningResult 최종결과 = LadderWinningResult.of(사다리, 참가자, 상품);

        assertAll(
                () -> assertThat(최종결과.findByName("pobi")).isEqualTo("3000"),
                () -> assertThat(최종결과.findByName("honux")).isEqualTo("5000"),
                () -> assertThat(최종결과.findByName("crong")).isEqualTo("꽝"),
                () -> assertThat(최종결과.findByName("jk")).isEqualTo("꽝")
        );
    }
}