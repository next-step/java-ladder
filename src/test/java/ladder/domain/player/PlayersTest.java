package ladder.domain.player;

import org.junit.jupiter.api.Test;
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

    @Test
    void Players는_최소_인원_이하로_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Players(List.of(new Player("name", 1)))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Players는_중복된_이름으로_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Players(List.of(new Player("name", 1), new Player("name", 1)))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
