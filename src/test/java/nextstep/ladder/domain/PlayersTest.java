package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    private Players players;
    private List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("jack", "pobi");
        players = Players.of(names);
    }

    @Test
    void countOfLines() {
        assertThat(players.countOfLines()).isEqualTo(1);
    }

    @Test
    void of() {
        assertThat(players.players()).isEqualTo(List.of(
                new Player("jack", Coordinate.of(0,0)),
                new Player("pobi", Coordinate.of(1,0))));
    }

    @Test
    void sameLength_fail() {
        assertThat(players.sameLength((List.of("X", "3000", "X")))).isFalse();
    }

    @Test
    void nameGiven_ReturnPlayers() {
        assertThat(players.player("jack")).isEqualTo(List.of(new Player("jack")));
        assertThat(players.player("all")).isEqualTo(players.players());
    }

    @ParameterizedTest
    @ValueSource(strings = {"jackkk", "allll"})
    void nameIsNotExistedGiven_ThrowExp(String name) {
        assertThatThrownBy(() -> players.player(name))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(LadderExceptionCode.NO_SUCH_PLAYER.getMessage());
    }
}
