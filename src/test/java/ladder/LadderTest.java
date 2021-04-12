package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이는 1 이상이어야 한다.")
    void createLadder() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(0))
                .withMessage("사다리 높이는 1 이상이어야 합니다: " + 0);
    }

    @Test
    @DisplayName("사다리를 만들고, 높이가 일치한지 확인한다.")
    void checkLadderHeight() {
        Ladder ladder = new Ladder(5);

        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
