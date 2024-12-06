package ladder.domain;

import ladder.exception.PlayersException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.PlayerNameTest.*;
import static ladder.domain.Players.NOT_ENOUGH_PLAYERS_SIZE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    public static final String POBI_HONUX_CRONG_JK = "pobi,honux,crong,jk";

    @Test
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players actual = new Players(POBI_HONUX_CRONG_JK);
        Players expected = new Players(List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK), new Vertical());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 목록을 생성실패한다: 플레이어 목록이 1명 미만")
    void create_실패_플레이어_목록이_1명_미만() {
        assertThatThrownBy(() -> {
            new Players(List.of(), new Vertical());
        }).isInstanceOf(PlayersException.class)
                .hasMessage(NOT_ENOUGH_PLAYERS_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("size 를 출력한다")
    void size() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void names() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        List<PlayerName> actual = players.names();
        List<PlayerName> expected = List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 사다리 높이를 출력한다")
    void vertical() {
        Players players = new Players(List.of(PLAYER_NAME_POBI, PLAYER_NAME_HONUX, PLAYER_NAME_CRONG, PLAYER_NAME_JK),
                new Vertical(1));

        Vertical actual = players.vertical();
        Vertical expected = new Vertical(1);

        assertThat(actual).isEqualTo(expected);
    }
}