package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step4.exception.DuplicateNameException;
import step4.exception.MinimumNameLengthException;
import step4.util.StringSpliter;

public class PlayersTest {
    @Test
    void 생성_테스트() {
        // given
        Players players = Players.of("dhlee, test1, test2");
        // when & then
        assertThat(players.playerCount()).isEqualTo(3);
    }

    @Test
    void 생성_테스트_2() {
        // given
        String test = "dhlee, test1, test2";
        Players players = Players.of(test);
        Players comparePlayers = Players.of(StringSpliter.split(test));
        // when & then
        assertThat(players).isEqualTo(comparePlayers);
    }

    @Test
    void 생성_유효성_테스트() {
        // given
        String test = "dhlee, ,gisun";
        // when & then
        Assertions.assertThrows(MinimumNameLengthException.class, () -> Players.of(test));
    }

    @Test
    void 생성_중복_테스트() {
        // given
        String test = "dhlee, dhlee";
        // when & then
        Assertions.assertThrows(DuplicateNameException.class, () -> Players.of(test));
    }
}
