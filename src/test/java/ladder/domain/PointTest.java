package ladder.domain;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

    @ParameterizedTest
    @EnumSource(LadderPoint.class)
    void 지정_LadderPoint로_포인트_생성_테스트(LadderPoint ladderPoint) {
        assertThat(Point.of(ladderPoint).toString()).isEqualTo(ladderPoint.toString());
    }

    @Test
    void 수직Point_생성_테스트() {
        assertThat(Point.ofVertical()).isEqualTo(Point.of(LadderPoint.VERTICAL_POINT));
    }

    @Test
    void EmptyPoint_생성_테스트() {
        assertThat(Point.ofEmptyHorizontal()).isEqualTo(Point.of(LadderPoint.EMPTY_POINT));
    }

    @Test
    void RandomHorizontalPoint_생성_테스트() {
        assertThat(Point.ofRandomHorizontal(() -> true)).isEqualTo(Point.of(LadderPoint.CONNECTED_POINT));
        assertThat(Point.ofRandomHorizontal(() -> false)).isEqualTo(Point.of(LadderPoint.EMPTY_POINT));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 8, 10})
    void ofOrder생성시_짝수번째_verticalPoint_생성_테스트(int order) {
        assertThat(Point.ofOrder(order)).isEqualTo(Point.of(LadderPoint.VERTICAL_POINT));
    }

    @Test
    void ofOrder생성시_홀수번째_horizontalPoint는_연속으로_ConnectedPoint가_나올_수_없다() {
        assertThat(Point.generateStatefulHorizontalPoint(() -> true)).isEqualTo(Point.of(LadderPoint.CONNECTED_POINT));
        assertThat(Point.generateStatefulHorizontalPoint(() -> true)).isNotEqualTo(Point.of(LadderPoint.CONNECTED_POINT));

    }
}