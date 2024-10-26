package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.dto.PlayerResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchResultTest {

    MatchResult matchResult;

    MatchResultTest() {
        int index = 0;
        List<Player> players = List.of(
                new Player("pobi", index++),
                new Player("jason", index++),
                new Player("crong", index++),
                new Player("jk", index++));
        List<String> ladderResults = List.of("5000", "꽝", "3000", "3000");

        this.matchResult = MatchResult.of(players, ladderResults);
    }

    @ParameterizedTest
    @CsvSource({
            "pobi,5000",
            "jason,꽝",
            "crong,3000",
            "jk,3000"
    })
    void getPlayerResultFromPlayerName(String playerName, String result) {
        assertThat(matchResult.playResult(playerName).getResult()).isEqualTo(result);
    }

    @Test
    void getAllPlayResult() {
        int index = 0;
        assertThat(matchResult.allPlayResults()).containsExactly(
                new PlayerResult(new Player("pobi", index++), "5000"),
                new PlayerResult(new Player("jason", index++), "꽝"),
                new PlayerResult(new Player("crong", index++), "3000"),
                new PlayerResult(new Player("jk", index++), "3000")
        );
    }

    @Test
    void throwExceptionIfNoPlayResultFromGivenPlayerName() {
        assertThatIllegalArgumentException().isThrownBy(() -> matchResult.playResult("nobody"));
    }
}
