package ladder.domain;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.Rewards;
import ladder.domain.factory.LadderFactory;
import ladder.domain.impl.RewardsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingResultTest {

    @DisplayName("사다리 게임 플레이어의 매칭 결과를 추출할 수 있다.")
    @Test
    void mapTest() {
        int heightOfLadder = 4;
        List<String> namesOfPeople = List.of("joe", "pobi", "kori");
        List<String> rewardList = List.of("꽝", "5000", "꽝", "3000");

        Players players = Players.of(namesOfPeople);
        Rewards rewards = RewardsImpl.of(rewardList);
        Ladder ladder = LadderFactory.createLadder(heightOfLadder, namesOfPeople.size());

        MatchingResult matchingResult = ladder.play();
        LadderResult result = matchingResult.map(players, rewards);

        Map<String, String> ladderResult = result.getLadderResult();

        assertThat(ladderResult.size()).isEqualTo(namesOfPeople.size());
        assertThat(ladderResult).containsKeys("joe", "pobi", "kori");
        assertThat(ladderResult.get("joe")).isNotNull();
        assertThat(ladderResult.get("pobi")).isNotNull();
        assertThat(ladderResult.get("kori")).isNotNull();
    }
}