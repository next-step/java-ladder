package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("4명이 참가할 수 있는 라인을 생성한다.")
    void createLineTest() {
        Line line = new Line(4);

        assertThat(line.getPointsSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("라인에 1번과 2번을 잇는 사다리를 만들고 이동한다.")
    void createBridgeAndMoveTest() {
        Line line = new Line(4);

        line.createBridge(0);

        assertThat(line.move(0)).isEqualTo(new Point(1));
    }

    @Test
    @DisplayName("1번 점에 의해 사다리가 만들어져도 2번 점에서 이동할 수 있다.")
    void createBridgeAndMoveFromOtherPointTest() {
        Line line = new Line(4);

        line.createBridge(0);

        assertThat(line.move(1)).isEqualTo(new Point(0));
    }

    @Test
    @DisplayName("이미 다리를 이은 곳에는 다리를 이을 수 없다.")
    void createDuplicateBridgeTest() {
        Line line = new Line(4);

        line.createBridge(0);

        assertThatIllegalStateException()
                .isThrownBy(() -> line.createBridge(0))
                .withMessageMatching("해당 지점에 사다리가 존재합니다: \\d+");
    }

    @Test
    @DisplayName("다른 점에 의해 다리가 지어져도, 이미 다리를 지은 것으로 판단한다.")
    void createBridgeAtEndPointTest() {
        Line line = new Line(4);

        line.createBridge(0);

        assertThatIllegalStateException()
                .isThrownBy(() -> line.createBridge(1))
                .withMessageMatching("해당 지점에 사다리가 존재합니다: \\d+");
    }

    @Test
    @DisplayName("음수 지점에 사다리를 지을 수 없습니다.")
    void createBridgeAtStrangePointTest() {
        Line line = new Line(4);
        int createAt = -1;

        assertThatIllegalStateException()
                .isThrownBy(() -> line.createBridge(createAt))
                .withMessage("해당 지점에 사다리를 지을 수 없습니다: " + createAt);
    }

    @Test
    @DisplayName("마지막 지점에는 사다리를 지을 수 없습니다.")
    void createBridgeAtFinalPointTest() {
        Line line = new Line(4);
        int createAt = 3;

        assertThatIllegalStateException()
                .isThrownBy(() -> line.createBridge(createAt))
                .withMessage("해당 지점에 사다리를 지을 수 없습니다: " + createAt);
    }

    @Test
    @DisplayName("Line 생성 시 인원은 적어도 1명 이상이어야 합니다.")
    void createLineWithInvalidCountOfPerson() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(0))
                .withMessage("인원은 적어도 1명 이상이어야 합니다: " + 0);
    }
}
