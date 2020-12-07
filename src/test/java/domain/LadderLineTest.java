package domain;

import ladder.domain.LadderLines;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderLineTest {

    private static LadderLines LadderLinesTest;

    @ParameterizedTest
    @DisplayName("입력받은 사다리 높이가 0 또는 음수일 때 예외를 던진다")
    @ValueSource(ints = {0, -100, -200, -3})
    void checkLadderHeight(int ladderHeight){
        assertThatThrownBy(() ->
                LadderLinesTest = new LadderLines(ladderHeight, 10)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }
}
