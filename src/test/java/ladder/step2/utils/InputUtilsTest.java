package ladder.step2.utils;

import ladder.step2.domain.Players;
import ladder.step2.dto.PlayerNameDTO;
import ladder.step2fixture.domain.PlayersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputUtilsTest {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    
    @Test
    @DisplayName("입력한 플레이어들의 객체를 반환받는다.")
    void inputPlayerNames() {
        Players players = InputUtils.getPlayers("pobi, honux, jun,jk");
        List<PlayerNameDTO> playerNameDTOS = players.playerNamesInformation();
        List<String> collect = playerNameDTOS.stream()
                .map(PlayerNameDTO::getPlayerName)
                .collect(Collectors.toList());
        
        assertThat(collect).isEqualTo(Arrays.asList("pobi", "honux", "jun", "jk"));
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 구분자가 쉼표가 아니면 예외 던지기")
    void inputPlayerNamesDelimiterException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getPlayers("pobi, jun, honux. jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 한 플레이어 이름의 글자 5자 초과 시 예외 던지기")
    void inputPlayerNamesLengthException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getPlayers("pobi, tjdtls, honux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 알파벳이 아닌 경우 예외 던지기")
    void inputPlayerNamesNonAlphabeticException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getPlayers("pobi, jun, ho2ux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("플레이어 이름 입력 시, null or empty 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void inputPlayerNamesNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getPlayers(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("최대 사다리의 높이 입력 값을 반환한다.")
    void inputLadderHeight() {
        int ladderHeight = InputUtils.getLadderHeight("11");
        assertThat(ladderHeight).isEqualTo(11);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 숫자가 아닌 값 입력 시 예외 던지기")
    void inputLadderHeightNonNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getLadderHeight("abc"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, null or empty 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void inputLadderHeightNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getLadderHeight(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, 그냥 0 또는 두 자릿수 이상에서 첫번째 자리에 0을 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "04", "011"})
    void inputLadderHeightZeroException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getLadderHeight(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 음수를 입력 시 예외 던지기")
    void inputLadderHeightNegativeNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputUtils.getLadderHeight("-2"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
}