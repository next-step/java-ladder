package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderMaterial;
import nextstep.ladder.domain.ladder.LineMaterial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 실행")
    void play() {
        Ladder ladder = createLadder();
        Player playerA = new Player("a");
        Player playerB = new Player("b");
        Player playerC = new Player("c");
        LadderReward ggang = LadderReward.from("꽝");
        LadderReward lucky = LadderReward.from("당첨");
        LadderReward lucky2 = LadderReward.from("당첨2");
        LadderGameInfo ladderGameInfo = new LadderGameInfo(new Players(Arrays.asList(playerA, playerB, playerC)),
                new LadderRewards(Arrays.asList(ggang, lucky, lucky2)));

        LadderGame ladderGame = LadderGame.of(ladder, ladderGameInfo);
        LadderGameResult ladderGameResult = ladderGame.play();

        Map<Player, LadderReward> expectedResults = new HashMap<>();
        expectedResults.put(playerA, lucky);
        expectedResults.put(playerB, ggang);
        expectedResults.put(playerC, lucky2);

        assertThat(ladderGameResult).isEqualTo(LadderGameResult.from(expectedResults));
    }

    private Ladder createLadder() {
        /*
         *  0   1   2
         *  |---|   |
         *  |---|   |
         *  |---|   |
         */
        LineMaterial lineMaterial = LineMaterial.of(3, () -> true);
        LadderMaterial ladderMaterial = LadderMaterial.of(3, lineMaterial);
        return Ladder.from(ladderMaterial);
    }

}
