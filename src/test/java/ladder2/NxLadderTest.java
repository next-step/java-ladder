package ladder2;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder2.Controller;
import nextstep.ladder2.domain.NxLadder;
import nextstep.ladder2.domain.builder.TestBuilder;
import nextstep.ladder2.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxLadderTest {
    @Test
    @DisplayName("사다리 높이는 1 이상이어야 한다.")
    void createLadder() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new NxLadder(0, 2, new TestBuilder()))
                .withMessage("사다리 높이는 1 이상이어야 합니다: " + 0);
    }

    @Test
    @DisplayName("미리 입력된 사다리를 그려주는지 확인한다.")
    void preDefinedLadderBuildTest() {
        NxLadder ladder = new NxLadder(5, 4, new TestBuilder());
        Controller controller = new Controller();

        // UI로 확인
        ResultView.printLadderResult(controller.convertToLadderViewDto(ladder.getLines()), 4);
    }

    @Test
    @DisplayName("미리 입력된 사다리를 타고 최종 Point를 확인한다.")
    void rideLadderBuildTest() {
        NxLadder ladder = new NxLadder(5, 4, new TestBuilder());

        assertThat(ladder.ride(0)).isEqualTo(0);
        assertThat(ladder.ride(1)).isEqualTo(3);
        assertThat(ladder.ride(2)).isEqualTo(2);
        assertThat(ladder.ride(3)).isEqualTo(1);
    }
}
