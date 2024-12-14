package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointFactoryTest {

    @Test
    @DisplayName("생성된 사다리 라인 한줄의 양옆 Point를 생성 중에 첫번째라인은 왼쪽 Point는 무조건 false")
    void generatePoint_first() {
        Point point = PointFactory.generatePoint(0, LineTest.LINE_TRUE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(true);

        point = PointFactory.generatePoint(0, LineTest.LINE_TRUE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(true);

        point = PointFactory.generatePoint(0, LineTest.LINE_FALSE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(0, LineTest.LINE_FALSE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(false);
    }

    @Test
    @DisplayName("생성된 사다리 라인 한 줄의 양옆 Point를 생성 중에 중간번째 라인은 양옆 Point")
    void generatePoint_middle() {
        Point point = PointFactory.generatePoint(1, LineTest.LINE_TRUE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(true);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(2, LineTest.LINE_TRUE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(true);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(1, LineTest.LINE_FALSE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(true);

        point = PointFactory.generatePoint(2, LineTest.LINE_FALSE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(true);

        point = PointFactory.generatePoint(1, LineTest.LINE_FALSE_FALSE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(2, LineTest.LINE_TRUE_TRUE_TRUE);
        assertThat(point.getLeft()).isEqualTo(true);
        assertThat(point.getRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("생성된 사다리 라인 한줄의 양옆 Point를 생성 중에 마지막 오른쪽 Point는 무조건 false")
    void generatePoint_last() {
        Point point = PointFactory.generatePoint(3, LineTest.LINE_TRUE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(true);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(3, LineTest.LINE_TRUE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(3, LineTest.LINE_FALSE_TRUE_FALSE);
        assertThat(point.getLeft()).isEqualTo(false);
        assertThat(point.getRight()).isEqualTo(false);

        point = PointFactory.generatePoint(3, LineTest.LINE_FALSE_FALSE_TRUE);
        assertThat(point.getLeft()).isEqualTo(true);
        assertThat(point.getRight()).isEqualTo(false);
    }
}
