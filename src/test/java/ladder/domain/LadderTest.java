package ladder.domain;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99999, 0x7fffffff})
    @DisplayName("정상적인 이름들을 승인할 수 있다")
    void validatesLadderHeights(int inputInteger) {
        Ladder ladder = new Ladder(inputInteger);
        assertThat(ladder.height()).isEqualTo(inputInteger);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -99999, 0x80000000})
    @DisplayName("0이나 음수를 사다리 높이로 주면 INVALID_LADDER_HEIGHT을 던진다")
    void negativeInputThrowsException(int inputInteger) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Ladder(inputInteger));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_LADDER_HEIGHT);
    }

}
