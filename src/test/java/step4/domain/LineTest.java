package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("좌우로 동시에 진행하는 중복Line 제거 및 정상 제거 판단")
    @Test
    void removeDirection() {
        Line line = new Line(true);
        line.setPointSetp(PointStep.RIGHT);
        line.removeDirection(PointStep.RIGHT);
        assertThat(line.getPointStep()).isEqualTo(PointStep.NONE);
    }

}
