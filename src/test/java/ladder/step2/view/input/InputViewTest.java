package ladder.step2.view.input;

import ladder.step2.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    
    @Test
    @DisplayName("입력한 플레이어들의 객체를 반환받는다.")
    void inputPlayerNames() {
        List<Player> players = InputView.inputPlayerNames("pobi, jun, honux, jk");
        assertThat(players).isEqualTo(Arrays.asList(new Player("pobi"), new Player("jun"), new Player("honux"), new Player("jk")));
    }
    
    @Test
    @DisplayName("구분자가 쉼표가 아니면 예외 던지기")
    void delimiterException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, jun, honux. jk"))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("입력한 이름의 글자 5자 초과 시 예외 던지기")
    void inputLengthException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, tjdtls, honux, jk"))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("알파벳이 아닌 경우 예외 던지기")
    void nonAlphabeticException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.inputPlayerNames("pobi, jun, ho1ux, jk"))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
}