package ladder;

import ladder.domain.GamePrize;
import ladder.domain.LadderBuildingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamePrizeTest {

    @DisplayName("객체 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bb", "꽝", "5055"})
    public void makeGamePrize_정상(String name) {
        assertThatCode(() -> {
            new GamePrize(name);
        }).doesNotThrowAnyException();
    }

    @DisplayName("객체 생성 실패 (객체 이름이 빈문자열 혹은 null)")
    @ParameterizedTest
    @NullAndEmptySource
    public void makeGamePrize_예외(String name) {
        assertThatThrownBy(() -> {
            new GamePrize(name);
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.INVALID_GAME_PRIZE_NAME);
    }
}
