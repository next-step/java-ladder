package ladder.step2.domain;

import ladder.step2.dto.PlayerNameDTO;
import ladder.step2fixture.domain.PlayersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    
    @Test
    @DisplayName("여러 플레이어들의 일급 콜렉션 생성")
    void create() {
        assertThat(PlayersFixture.PLAYERS).isNotNull();
    }
    
    @Test
    @DisplayName("입력한 플레이어들의 객체를 반환받는다.")
    void inputPlayerNames() {
        Players players = new Players("pobi, honux, jun,jk");
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
                .isThrownBy(() -> new Players("pobi, jun, honux. jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 한 플레이어 이름의 글자 5자 초과 시 예외 던지기")
    void inputPlayerNamesLengthException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players("pobi, tjdtls, honux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름 입력 시, 알파벳이 아닌 경우 예외 던지기")
    void inputPlayerNamesNonAlphabeticException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players("pobi, jun, ho2ux, jk"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("플레이어 이름 입력 시, null or empty 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void inputPlayerNamesNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("플레이어 이름들 DTO 리스트 데이터 확인")
    void player_names_dto() {
        List<String> playerNames = PlayersFixture.PLAYERS.playerNamesInformation().stream()
                .map(PlayerNameDTO::getPlayerName)
                .collect(Collectors.toList());
        assertThat(playerNames).isEqualTo(Arrays.asList("pobi", "honux", "jun", "jk"));
    }
    
    @Test
    @DisplayName("플레이어 이름들 DTO 리스트 데이터 확인")
    void player_names_size() {
        int size = PlayersFixture.PLAYERS.size();
        assertThat(size).isEqualTo(4);
    }
}
