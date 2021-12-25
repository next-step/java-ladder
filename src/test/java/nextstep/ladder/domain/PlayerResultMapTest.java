package nextstep.ladder.domain;

import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prizes;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerResultMapTest {
    @Test
    public void result() {
        String p1 = "p1";
        String p2 = "p2";
        String pz1 = "pz1";
        String pz2 = "pz2";
        Players players = ps(p1, p2);
        Prizes prizes = pzs(pz1, pz2);
        assertThat(PlayerResultMap.of(players, prizes).result(pn(p1))).isEqualTo(pz(pz1));
        assertThat(PlayerResultMap.of(players, prizes).result(pn(p2))).isEqualTo(pz(pz2));
    }
}
