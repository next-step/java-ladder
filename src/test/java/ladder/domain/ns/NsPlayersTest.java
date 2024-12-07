package ladder.domain.ns;

import ladder.domain.interfaces.Players;
import ladder.domain.interfaces.Vertical;
import ladder.domain.wrapper.PlayerName;
import ladder.exception.PlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ns.NsPlayers.NOT_ENOUGH_PLAYERS_SIZE_MESSAGE;
import static ladder.domain.wrapper.PlayerNameTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NsPlayersTest {
    public static final String POBI_HONUX_CRONG_JK = "pobi,honux,crong,jk";

    @Test
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players actual = new NsPlayers(POBI_HONUX_CRONG_JK);
        Players expected = new NsPlayers(List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK), new NsVertical());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 목록을 생성실패한다: 플레이어 목록이 1명 미만")
    void create_실패_플레이어_목록이_1명_미만() {
        assertThatThrownBy(() -> {
            new NsPlayers(List.of(), new NsVertical());
        }).isInstanceOf(PlayersException.class)
                .hasMessage(NOT_ENOUGH_PLAYERS_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("size 를 출력한다")
    void size() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void names() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        List<PlayerName> actual = players.names();
        List<PlayerName> expected = List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 사다리 높이를 출력한다")
    void vertical() {
        Players players = new NsPlayers(List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK),
                new NsVertical(1));

        Vertical actual = players.vertical();
        Vertical expected = new NsVertical(1);

        assertThat(actual).isEqualTo(expected);
    }
}