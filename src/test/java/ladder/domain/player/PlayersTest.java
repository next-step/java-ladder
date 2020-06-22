package ladder.domain.player;

import ladder.domain.data.PlayerData;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.create(null));
    }

    @DisplayName("입력 사이즈가 2보다 작으면 예외 발생")
    @Test
    void createInvalidCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.create(PlayerData.make(1)));
    }
}
