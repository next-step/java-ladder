package ladder.domain.ladder;

import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 높이 입력시 같은 높이를 가진 사다리 생성")
    void createLadder() {
        int ladderHeight = 5;

        Ladder ladder = Ladder.of(5, ladderHeight, new TrueLineStrategy());

        assertThat(ladder.height()).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("사다리 높이가 음수일 때 예외 발생")
    void throwExceptionWhenNegativeInput() {
        int ladderHeight = -1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Ladder.of(5, ladderHeight, new TrueLineStrategy());
        }).withMessageMatching("Ladder height must be positive.");
    }
}
