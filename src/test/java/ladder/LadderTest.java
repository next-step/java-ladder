package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.strategy.BridgeBuilder;
import nextstep.ladder.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이는 1 이상이어야 한다.")
    void createLadder() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(0, 2))
                .withMessage("사다리 높이는 1 이상이어야 합니다: " + 0);
    }

    @Test
    @DisplayName("미리 입력된 사다리를 그려주는지 확인한다.")
    void preDefinedLadderBuildTest() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");
        Ladder ladder = new Ladder(5, 4, new BridgeBuilder(predefined));

        List<String> created = ladder.build();

        assertThat(created).isEqualTo(predefined);

        // UI로 확인
        System.out.println("<1>");
        ResultView.printLadderResult(predefined, 4);
        System.out.println("<2>");
        ResultView.printLadderResult(created, 4);
    }

    @Test
    @DisplayName("미리 입력된 사다리를 타고 최종 Point를 확인한다.")
    void rideLadderBuildTest() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");
        Ladder ladder = new Ladder(5, 4, new BridgeBuilder(predefined));

        ladder.build();

        assertThat(ladder.ride(new Point(0))).isEqualTo(new Point(0));
        assertThat(ladder.ride(new Point(1))).isEqualTo(new Point(3));
        assertThat(ladder.ride(new Point(2))).isEqualTo(new Point(2));
        assertThat(ladder.ride(new Point(3))).isEqualTo(new Point(1));
    }
}
