package ladder.domain.player;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Players는_players_없이_생성_할_경우_예외를_발생_시킨다(List<Player> players) {
        assertThatThrownBy(
                () -> new Players(players)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
