package laddergame.domain.player;

import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    private static final int PLAYERS_NUMBER = 3;

    private List<Name> nameList = new ArrayList<>();
    private List<Player> playerList = new ArrayList<>();
    private Players players;

    @BeforeEach
    void setUp() {
        for (int i=0; i<PLAYERS_NUMBER; i++) {
            Name name = new Name("이름"+i);
            playerList.add(new Player(name));
        }
        players = new Players(playerList);
    }

    @Test
    void 플레이어목록을생성() {
        assertThat(players).isEqualTo(new Players(playerList));
    }

    @Test
    void 플레이어이름은_중복될수없다() {
        playerList.add(new Player(new Name("이름"+0)));
        assertThatThrownBy(() -> {
            new Players(playerList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 플레이어목록은_비어있을수없다(List<?> input) {
        assertThatThrownBy(() -> {
            new Players((List<Player>) input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
