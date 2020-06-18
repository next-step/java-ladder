package ladder;

import ladder.domain.LadderBuildingException;
import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("Player 객체 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"hyeju", "liam", "noel", "doe"})
    public void makePlayer_정상(String name) {
        assertThatCode(() -> {
            new Player(name);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Player 객체 생성 실패 테스트(이름이 5자를 초과 or Null or 빈 문자열)")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"jihoon", "americano", "espresso"})
    public void makePlayer_예외(String name) {
        assertThatThrownBy(() -> {
            new Player(name);
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.INVALID_PLAYER_NAME);
    }
}
