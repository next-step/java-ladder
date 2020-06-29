package ladder.domain.player;

import ladder.domain.data.PlayerData;
import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    @DisplayName("리스트의 길이보다 작으면 True를 반환")
    @Test
    void hasIndexTrue() {
        Players players = Players.create(PlayerData.make(10));
        assertThat(players.hasIndex(9)).isTrue();
    }

    @DisplayName("리스트의 길이보다 크거나 같으면 False를 반환")
    @Test
    void hasIndexFalse() {
        Players players = Players.create(PlayerData.make(10));
        assertThat(players.hasIndex(10)).isFalse();
    }
}
