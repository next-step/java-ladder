package nextstep.ladder.domain;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayersTest {
    private Players players;

    @BeforeEach
    void setUp() {
        players = Players.from("james,kim,jade,lee,choi");
    }

    @ParameterizedTest
    @DisplayName(value = "참가자 생성 인원수")
    @CsvSource(value = {"james,kim,jade,lee,choi:5", "james,kim:2"}, delimiter = ':')
    void playersCount(String input, int result) {
        assertThat(Players.from(input)
                .countOfPlayers())
                .isEqualTo(result);
    }

    @Test
    @DisplayName(value = "참가자 객체 생성")
    void playersArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Players.from("");
                });
    }

    @ParameterizedTest
    @DisplayName(value = "참가자 이름에 맞는 참가자 객체 반환")
    @CsvSource(value = {"james:0", "kim:1", "jade:2", "lee:3", "choi:4"}, delimiter = ':')
    void playerEquals(String input, int position) {
        assertThat(players.player(input))
                .isEqualTo(new Player(input, position));
    }

    @Test
    @DisplayName(value = "참가자 이름 리스트 반환")
    void playerNames() {
        List<String> names = new ArrayList<String>() {
            {
                add("james");
                add("kim");
                add("jade");
                add("lee");
                add("choi");
            }
        };

        assertThat(players.names()
                .containsAll(names))
                .isEqualTo(true);
    }
}