package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("게임 참가자 이름 테스트")
public class PlayerNameTest {

    @DisplayName("참가자 이름이 비어있으면 예외가 발생한다.")
    @Test
    void emptyNameExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(null))
                .withMessage("참가자 이름이 비어있습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(""))
                .withMessage("참가자 이름이 비어있습니다.");
    }

    @DisplayName("참가자 이름이 5자를 넘어가면 예외가 발생한다.")
    @Test
    void exceedMaxNameLengthExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName("abcdef"))
                .withMessage("참가자 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("참가자 이름이 주입받은 이름 그대로 정상 생성되어야 한다.")
    @Test
    void createPlayerNameTest() {
        // given, when
        PlayerName playerName = new PlayerName("aiden");

        // then
        assertEquals(playerName.getName(), "aiden");
    }
}
