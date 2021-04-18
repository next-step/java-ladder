package laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static laddergame.util.StringUtils.fitSpace;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    private static final int PLAYERS_NUMBER = 3;

    private List<Player> playerList = new ArrayList<>();
    private Players players;

    @BeforeEach
    void setUp() {
        players = makeTestPlayers(PLAYERS_NUMBER);
        IntStream.range(0, PLAYERS_NUMBER)
                .forEach(i -> playerList.add(new Player(new Name("이름" + i))));
    }

    @Test
    void 플레이어목록을생성() {
        assertThat(players).isEqualTo(new Players(playerList));
    }

    @Test
    void 플레이어이름은_중복될수없다() {
        playerList.add(new Player(new Name("이름" + 0)));
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

    @Test
    @DisplayName("플레이어의 이름이 일치하는 순번쨰 index를 반환한다.")
    void 이름이일치인덱스반환() {
        int index = 2;
        Name findName = new Name("이름" + index);

        int findIndex = players.whoseName(findName);

        assertThat(findIndex).isEqualTo(index);
    }

    @Test
    void 없는이름찾기() {
        assertThatThrownBy(() -> {
            players.whoseName(new Name("없는이름"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어목록프린트() {
        List<Player> playerList = players.getPlayers();
        playerList.stream()
                .forEach(player -> System.out.print(fitSpace(player.toString())));
        System.out.println();
    }

    public static Players makeTestPlayers(int number) {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Name name = new Name("이름" + i);
            playerList.add(new Player(name));
        }
        return new Players(playerList);
    }
}
