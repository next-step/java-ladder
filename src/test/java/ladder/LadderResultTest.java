package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    public void 결과생성() {
        LadderResult ladderResult =
            new LadderResult(new Ladder(3, 3, 3)
                , LadderPlayers.createPlayers("1,2,3")
                , Prizes.createPrizes("a,s,d"));

        assertThat(ladderResult.getLadderResult().size()).isEqualTo(3);

    }
}