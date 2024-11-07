package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("사다리 점 왼쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_왼쪽_연결_테스트() {
        Line line = new Line();

        line.connectLeft();

        assertThat(line.isLeftConnected()).isTrue();
    }

    @Test
    @DisplayName("사다리 점 오른쪽으로 연결되는지 테스트를 한다")
    void 사다리_점_오른쪽_연결_테스트() {
        Line line = new Line();

        line.connectRight();

        assertThat(line.isRightConnected()).isTrue();
    }

    @Test
    @DisplayName("왼쪽으로 연결된 상태일 때 오른쪽으로 연결 시도하면 오른쪽은 연결되지 않는다")
    void connectRightFailwhenLeftAlreadyConnected() {
        Line line = Line.first();

        line.connectRight();

        assertThat(line.isRightConnected()).isFalse();
    }

    @Test
    @DisplayName("오른쪽으로 연결된 상태일 때 왼쪽으로 연결 시도하면 왼쪽은 연결되지 않는다")
    void connectLeftFailwhenRightAlreadyConnected() {
        Line line = Line.last();

        line.connectLeft();

        assertThat(line.isLeftConnected()).isFalse();
    }

    @Test
    @DisplayName("양쪽으로 연결된 라인을 생성 시 예외 발생")
    void 양쪽으로_연결된_라인_생성_시_예외_발생() {
        assertThatThrownBy(() -> Line.firstAndLast())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속으로 연결된 라인은 생성할 수 없습니다");
    }

    @Test
    @DisplayName("좌우로 연결되지 않은 지점은 그냥 내려간다")
    void 좌우로_연결되지_않은_지점은_그냥_내려감() {
        Line line = new Line();
        int location = 0;

        location = line.tryMove(location);

        assertThat(location).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽으로 연결된 지점은 왼쪽으로 이동 후 내려간다")
    void 왼쪽으로_연결된_지점은_왼쪽으로_이동_후_내려감() {
        Line line = Line.first();
        int location = 1;

        location = line.tryMove(location);

        assertThat(location).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽으로 연결된 지점은 왼쪽으로 이동 후 내려간다")
    void 오른쪽으로_연결된_지점은_오른쪽으로_이동_후_내려감() {
        Line line = Line.first();
        int location = 1;

        location = line.tryMove(location);

        assertThat(location).isEqualTo(0);
    }

}
