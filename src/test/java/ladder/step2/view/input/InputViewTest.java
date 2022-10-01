package ladder.step2.view.input;

import ladder.step2.domain.Players;
import ladder.step2.domain.PlayersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    
    @Test
    @DisplayName("입력한 플레이어들의 객체를 반환받는다.")
    void inputPlayerNames() {
        Players players = InputView.inputPlayerNames("pobi, honux, jun,jk");
        assertThat(players).isEqualTo(PlayersTest.PLAYERS);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 구분자가 쉼표가 아니면 예외 던지기")
    void inputPlayerNamesDelimiterException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, jun, honux. jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 한 플레이어 이름의 글자 5자 초과 시 예외 던지기")
    void inputPlayerNamesLengthException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, tjdtls, honux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 알파벳이 아닌 경우 예외 던지기")
    void inputPlayerNamesNonAlphabeticException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, jun, ho2ux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("플레이어 이름 입력 시, null or empty 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void inputPlayerNamesNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("최대 사다리의 높이 입력 값을 반환한다.")
    void inputLadderHeight() {
        int ladderHeight = InputView.inputLadderHeight("11");
        assertThat(ladderHeight).isEqualTo(11);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 숫자가 아닌 값 입력 시 예외 던지기")
    void inputLadderHeightNonNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputLadderHeight("abc"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, null or empty 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void inputLadderHeightNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputLadderHeight(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, 그냥 0 또는 두 자릿수 이상에서 첫번째 자리에 0을 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "04", "011"})
    void inputLadderHeightZeroException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputLadderHeight(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 음수를 입력 시 예외 던지기")
    void inputLadderHeightNegativeNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputLadderHeight("-2"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
}