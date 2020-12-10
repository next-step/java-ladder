package domain;

import ladder.domain.Ladder;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderLineTest {
    private static Ladder LadderLineTest;

    @ParameterizedTest
    @DisplayName("입력받은 사다리 높이가 0 또는 음수일 때 예외를 던진다")
    @ValueSource(ints = {0, -100, -200, -3})
    void checkLadderHeight(int ladderHeight){
        assertThatThrownBy(() ->
                LadderLineTest = new Ladder(ladderHeight, 10)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }
}
