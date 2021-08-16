package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("게임 참가자 이름 테스트")
public class PlayerNameTest {

    @DisplayName("참가자 이름이 비어있으면 예외가 발생한다.")
    @Test
    void emptyPlayerNameExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(null))
                .withMessage("참가자 이름이 비어있습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(""))
                .withMessage("참가자 이름이 비어있습니다.");
    }
}
