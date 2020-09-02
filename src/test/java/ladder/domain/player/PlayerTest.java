package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("Player 생성 테스트")
    @Test
    void createPlayerTest() {
        Player player = Player.of("test");
        assertThat(player).isEqualTo(Player.of("test"));
    }

    @DisplayName("Player 생성 예외처리 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"jhpark", "player"})
    void playerExceptionTest(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Player.of(name));
    }
}