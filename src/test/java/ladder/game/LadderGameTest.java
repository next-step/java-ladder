package ladder.game;

import ladder.model.ladder.Ladder;
import ladder.model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LadderGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"6","7","8","9","0"})
    @DisplayName("resultOf에 실제 참가자 이름이나, all 값이 아닐 경우 예외 발생 테스트")
    void notValidResultOfValueExceptionTest(String resultOf) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(Ladder.create(5, 5), new Players("1,2,3,4,5")).play(resultOf))
                .withMessage("해당 이름을 가진 참가자가 없습니다.");
    }
}
