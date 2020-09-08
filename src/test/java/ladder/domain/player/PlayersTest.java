package ladder.domain.player;

import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "EEE,FFF,GGG,HHH=4",
            "BBB,CCC,DDD=3",
            "AAA,YKJ=2"
    }, delimiter = '=')
    @DisplayName("플레이어들이 잘 생생되는지 테스트")
    public void players_test(String names, int countOfPlayers) {
        // given
        Players players = Players.of(names);

        // when & then
        assertThat(players.getCountOfPlayers()).isEqualTo(countOfPlayers);
    }

}
