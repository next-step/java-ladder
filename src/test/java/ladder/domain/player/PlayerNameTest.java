package ladder.domain.player;

import ladder.model.player.PlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerNameTest {
    @DisplayName("플레이어 이름으로 다섯 글자 이상으로 작성하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"Shuhua", "Soyeon", "Miyeon"})
    void createTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerName(input);
        });
    }
}
