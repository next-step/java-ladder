package nextstep.ladder;

import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.OrderedLadderGameResult;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {
    LadderGameResult result;

    @BeforeEach
    void setUp() {
        result = new OrderedLadderGameResult();

        Player playerKim = new Player("kim");
        Player playerLee = new Player("lee");

        Prize firstPrize = new Prize("1등");
        Prize secondPrize = new Prize("2등");

        result.add(playerKim, firstPrize);
        result.add(playerLee, secondPrize);
    }

    @Test
    void findByPlayer_선수의_결과를_반환한다() {
        assertThat(result.findByPlayer("kim")).isEqualTo(new Prize("1등"));
    }
}
