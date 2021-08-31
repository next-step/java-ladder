package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WonderingPlayersTest {

    @ParameterizedTest(name = "isEqualSizeTo 테스트 | {arguments}")
    @CsvSource(value = {"a,b,c|iiaii|false", "a,b,c|all|true"}, delimiter = '|')
    public void isEqualSizeTo(String playersInput, String wonderingPlayersInput, boolean expected) {
        // given
        Players players = new Players(playersInput);
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, wonderingPlayersInput);

        // when
        boolean equalSizeTo = wonderingPlayers.isEqualSizeTo(players);

        // then
        assertThat(equalSizeTo).isEqualTo(expected);
    }

    @Test
    @DisplayName("getPlayers 테스트 - all")
    public void getPlayersAll() {
        // given
        Players players = new Players("a,b,c");
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, "all");
        int expectedSize = 3;

        // when
        List<Player> result = wonderingPlayers.getWonderingPlayers();

        // then
        assertThat(result.size()).isEqualTo(expectedSize);
        assertThat(result).containsExactly(
                new Player("a"),
                new Player("b"),
                new Player("c"));
    }

    @Test
    @DisplayName("getPlayers 테스트 - 한명")
    public void getPlayersOne() {
        // given
        Players players = new Players("iiaii,!!e!!");
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, "iiaii");
        int expectedSize = 1;

        // when
        List<Player> result = wonderingPlayers.getWonderingPlayers();

        // then
        assertThat(result.size()).isEqualTo(expectedSize);
        assertThat(result).containsExactly(new Player("iiaii"));
    }

}