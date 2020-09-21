package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    @Test
    @DisplayName("create & size 체크")
    void createAndSize() {
        String playerNames = "crong,pobi,bipo";
        String separator = ",";
        assertThat(Players.of(playerNames, separator).size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:crong", "1:pobi", "2:bipo"}, delimiter = ':')
    @DisplayName("Location에 맞는 Player 얻어오기")
    void getPlayer(int location, String playerName) {
        String playerNames = "crong,pobi,bipo";
        Players players = Players.of(playerNames, ",");
        assertThat(players.getPlayer(Location.from(location))).isEqualTo(new Player(playerName));
    }
}
