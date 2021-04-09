package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                .isThrownBy(() -> new Line(pointCount, new RandomLineWriteStrategy()))
                .withMessageMatching("라인 생성을 위해서는 최소 두 개의 점이 필요합니다.");
    }

    @Test
    @DisplayName("겹치는 라인 생성 방지 - 항상 라인을 그리는 경우 첫 번째 Point에만 라인이 생긴다.")
    void lineCreate_alwaysLineWrite() {
        // given when
        Line line = new Line(5, () -> true);

        // then
        Assertions.assertThat(line.getPointList().get(0).hasLine()).isTrue();
        for (int i = 1; i < line.getPointList().size(); i++) {
            Assertions.assertThat(line.getPointList().get(i).hasLine()).isFalse();
        }
    }

}