package domain;

import ladder.domain.Ladder;
import ladder.domain.LadderDirection;
import ladder.domain.LadderPoint;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderLineTest {
    private static Ladder ladderLineTest;

    @ParameterizedTest
    @DisplayName("입력받은 사다리 높이가 0 또는 음수일 때 예외를 던진다")
    @ValueSource(ints = {0, -100, -200, -3})
    void checkLadderHeight(int ladderHeight) {
        assertThatThrownBy(() ->
                ladderLineTest = new Ladder(ladderHeight, 10)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }
}
