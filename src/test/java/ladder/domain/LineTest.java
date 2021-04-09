package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1})
    @DisplayName("라인은 최소 두 개의 점으로 생성할 수 있다.")
    void lineCreate_lackOfPointCount(int pointCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(pointCount))
                .withMessageMatching("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");

        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(new RandomLineWriteStrategy(), pointCount))
                .withMessageMatching("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");
    }

    @Test
    @DisplayName("라인 생성 - 포인트 수")
    void lineCreate_pointCount() {
        // given when
        int pointCount = 10;
        Line line = new Line(pointCount);

        // then
        assertThat(pointCount).isEqualTo(line.getPointList().size());
    }

    @Test
    @DisplayName("라인 생성 - 가로줄이 없는 경우")
    void lineCreate_emptyHorizon() {
        // given when
        Line line = new Line(() -> false, 10);

        // then
        for (Point point : line.getPointList()) {
            assertThat(point.hasLine()).isFalse();
        }
    }

    @Test
    @DisplayName("겹치는 라인 생성 방지 - 항상 라인을 그리는 전략 활용")
    void lineCreate_alwaysLineWrite() {
        // given when
        Line line = new Line(() -> true, 10);

        // then
        Assertions.assertThat(line.getPointList().get(0).hasLine()).isTrue();
        for (int i = 1; i < line.getPointList().size()-1; i++) {
            boolean prevHasLine = line.getPointList().get(i-1).hasLine();
            Assertions.assertThat(line.getPointList().get(i).hasLine()).isNotEqualTo(prevHasLine);
        }
        Assertions.assertThat(line.getPointList().get(line.getPointList().size()-1).hasLine()).isFalse();
    }

}