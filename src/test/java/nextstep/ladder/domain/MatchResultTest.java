package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayerResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchResultTest {

    MatchResult matchResult;

    MatchResultTest() {
        List<Player> players = Stream.of("pobi", "jason", "crong", "jk")
                .map(Player::new)
                .collect(Collectors.toList());
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
    void get_player_result_from_player_name(String playerName, String result) {
        assertThat(matchResult.playResult(playerName).getResult()).isEqualTo(result);
    }

    @Test
    void get_all_play_result() {
        assertThat(matchResult.allPlayResults()).containsExactly(
                new PlayerResult(new Player("pobi"), "5000"),
                new PlayerResult(new Player("jason"), "꽝"),
                new PlayerResult(new Player("crong"), "3000"),
                new PlayerResult(new Player("jk"), "3000")
        );
    }

    @Test
    void throw_exception_if_no_play_result_from_given_player_name() {
        assertThatIllegalArgumentException().isThrownBy(() -> matchResult.playResult("nobody"));
    }
}
