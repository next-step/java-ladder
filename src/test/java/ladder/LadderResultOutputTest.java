package ladder;

import ladder.domain.LadderResultOutput;
import ladder.domain.Rewards;
import ladder.domain.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultOutputTest {


    Players players = new Players("iu,iu2,iu3,iu4");
    String reulstsString = "꽝1,꽝,5000원,5000";
    Rewards rewards = new Rewards(reulstsString);
    LadderResultOutput output = new LadderResultOutput(players, rewards);

    @Test
    void getResultTargetOutputTest() {
        assertThat(output.getResultTargetOutput("iu")).isEqualTo("꽝1");
    }

    @Test
    void getResultOutPutTest() {
        output.getResultOutput().forEach((name, rewardInfo) -> {
            assertThat(name).isEqualTo(players.getPlayerByName(name).getName());
        });
    }
}


