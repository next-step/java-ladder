package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("사다리 게임결과 맵핑 테스트")
    void mapping_result_test() {
        Players members = Players.of("pobi,crong,ykj");
        Rewards rewards = Rewards.builder()
                .countOfPlayers(3)
                .rewardInput("10000,5000,fail")
                .build();


        Map<Integer, Integer> results = new HashMap<>();
        results.put(0, 1);
        results.put(1, 0);
        results.put(2, 2);
        LadderResult ladderResult = LadderResult.of(results);

        Map<String, String> mappingResult = new HashMap<>();
        mappingResult.put("pobi", "5000");
        mappingResult.put("crong", "10000");
        mappingResult.put("ykj", "fail");

        GameResult gameResult = GameResult.of(mappingResult);

        assertThat(ladderResult.mappingResult(members, rewards)).isEqualTo(gameResult);
    }

}
