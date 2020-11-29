package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    @Test
    void getResult() {
        //given
        Map<String, String> playerReward = new HashMap<>();
        playerReward.put("a", "1");
        playerReward.put("b", "2");
        playerReward.put("c", "3");

        LadderGameResult ladderGameResult = new LadderGameResult(playerReward);
        assertThat(ladderGameResult.getResult()).isEqualTo(playerReward);
    }
}