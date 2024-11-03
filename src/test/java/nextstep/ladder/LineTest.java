package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("사다리 점 왼쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_왼쪽_연결_테스트() {
        Line line = new Line(false, false);

        line.connectLeft();

        assertThat(line.isLeftConnected()).isTrue();
    }

    @Test
    @DisplayName("사다리 점 오른쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_오른쪽_연결_테스트() {
        Line line = new Line(false, false);

        line.connectRight();

        assertThat(line.isRightConnected()).isTrue();
    }

}
