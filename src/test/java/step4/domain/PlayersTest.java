package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step4.exception.DuplicateNameException;
import step4.exception.MinimumNameLengthException;

public class PlayersTest {
    @Test
    void 생성_테스트() {
        // given
        Players players = new Players("dhlee, test1, test2");
        // when & then
        assertThat(players.playerCount()).isEqualTo(3);
    }

    @Test
    void 생성_유효성_테스트() {
        // given
        String test = "dhlee, ,gisun";
        // when & then
        Assertions.assertThrows(MinimumNameLengthException.class, () -> new Players(test));
    }

    @Test
    void 생성_중복_테스트() {
        // given
        String test = "dhlee, dhlee";
        // when & then
        Assertions.assertThrows(DuplicateNameException.class, () -> new Players(test));
    }
}
