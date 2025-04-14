package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {

    public static final String PLAYER_NAME = "more";
    public static final Position POSITION = new Position(0);
    public static final Player PLAYER = new Player(PLAYER_NAME, POSITION);
    public static final Players PLAYERS = new Players(List.of(PLAYER));

    @DisplayName("Player를 이름으로 찾는다.")
    @Test
    void findPlayerByName() {
        // when
        Player actual = PLAYERS.findPlayer(PLAYER_NAME);

        // then
        Assertions.assertThat(PLAYER).isEqualTo(actual);
    }

    @DisplayName("Player를 이름으로 찾을 수 없다.")
    @Test
    void findPlayerByNameNotFound() {
        // when
        Assertions.assertThatThrownBy(() -> PLAYERS.findPlayer("not_found"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Player not found");
    }

    @DisplayName("Player를 이름으로 찾을 수 없다. (null)")
    @Test
    void findPlayerByNameNull() {
        // when
        Assertions.assertThatThrownBy(() -> PLAYERS.findPlayer(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Player name cannot be null or empty");
    }
}
