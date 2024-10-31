package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리 높이가 1 미만인 경우 예외가 잘 발생하는지")
    @Test
    void createLadderWithInvalidHeight() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.createLadder(
                        new Participants("crong,honux"),
                        0,
                        new RandomLineDecisionStrategy()));
    }

    @DisplayName("사다리가 예상대로 잘 생성되는지")
    @Test
    void createLadderTest() {
        Participants participants = new Participants("pobi,honux,crong");
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, false,
                false, true,
                true, false
        );
        Ladder ladder = Ladder.createLadder(participants, 3, testStrategy);

        assertThat(ladder.toString()).isEqualTo(
                "pobi  honux crong\n" +
                        "    |-----|     |\n" +
                        "    |     |-----|\n" +
                        "    |-----|     |\n"
        );
    }

    @DisplayName("사다리가 생성되었을 때 연속된 선이 생기면 예외가 발생하는지")
    @Test
    void createLadderTest_NoContinuousLine() {
        Participants participants = new Participants("pobi,honux,crong");
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, true,
                true, true,
                true, true
        );

        assertThatThrownBy(() -> Ladder.createLadder(participants, 3, testStrategy))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
