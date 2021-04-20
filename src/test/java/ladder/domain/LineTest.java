package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        assertThat(pointCount).isEqualTo(line.getPoints().size());
    }

    @Test
    @DisplayName("라인 생성 - 가로줄이 없는 경우")
    void lineCreate_emptyHorizon() {
        // given when
        Line line = new Line(() -> false, 10);

        // then
        for (Point point : line.getPoints()) {
            assertThat(point.hasRightLine()).isFalse();
        }
    }

    @Test
    @DisplayName("라인 생성 - 라인쓰기 전략 미입력")
    void lineCreate_writeStrategyIsNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(null, 5))
                .withMessageMatching("라인 쓰기 형식을 입력해 주세요.");
    }

    @Test
    @DisplayName("겹치는 라인 생성 방지 - 항상 라인을 그리는 전략 활용")
    void lineCreate_alwaysLineWrite() {
        // given when
        Line line = new Line(() -> true, 10);

        // then
        assertAll(
                () -> assertThat(line.getPoints().get(0).hasRightLine()).isTrue(),
                () -> {
                    for (int i = 1; i < line.getPoints().size() - 1; i++) {
                        boolean prevHasRightLine = line.getPoints().get(i - 1).hasRightLine();
                        assertThat(line.getPoints().get(i).hasRightLine()).isNotEqualTo(prevHasRightLine);
                    }
                },
                () -> assertThat(line.getPoints().get(line.getPoints().size() - 1).hasRightLine()).isFalse()
        );
    }

    @Test
    @DisplayName("연결 포인트 조회 - 유효하지 않은 인덱스")
    void getLinkPointIndex_invalidIndex() {
        // given
        Line line = new Line(() -> true, 10);

        // when then
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> line.getLinkPointIndex(-1))
                        .withMessageMatching("유효하지 않은 인덱스 입니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> line.getLinkPointIndex(10))
                        .withMessageMatching("유효하지 않은 인덱스 입니다.")
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2", "3:4", "4:3"}, delimiter = ':')
    @DisplayName("연결 포인트 조회 - 인덱스별 정상조회")
    void getLinkPointIndex(int inputIndex, int outputIndex) {
        // given
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, new Direction(false, true)));
        points.add(new Point(1, new Direction(true, false)));
        points.add(new Point(2, new Direction(false, false)));
        points.add(new Point(3, new Direction(false, true)));
        points.add(new Point(4, new Direction(true, false)));

        // when
        Line line = new Line(points);

        // then
        assertThat(outputIndex).isEqualTo(line.getLinkPointIndex(inputIndex));
    }

}