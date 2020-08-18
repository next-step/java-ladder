package camp.nextstep.edu.rebellion.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @DisplayName("입력 값을 바탕으로 참가자가 잘 생성 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C,D,E:5",
            "11,22,33:3",
            "One:1"
    }, delimiter = ':')
    public void playerTest(String input, int expected) {
        // given
        Players players = new Players(input);

        // when & then
        assertThat(players.getCountOfPlayers()).isEqualTo(expected);
    }
}
