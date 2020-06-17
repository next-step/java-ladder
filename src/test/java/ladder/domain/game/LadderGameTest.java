package ladder.domain.game;

import ladder.domain.ladder.Lines;
import ladder.domain.ladder.LinesCreator;
import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void LadderGameStartTest() {
        String[] playersName = {"a", "b", "c", "d"};
        String[] rewards = {"100", "꽝", "1000", "꽝"};

        LadderPlayers ladderPlayers = LadderPlayers.participate(playersName);
        LadderRewards ladderRewards = LadderRewards.inputRewards(rewards);
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);
        Lines ladder = LinesCreator.create(ladderPlayers.getPlayerCount(), ladderHeight);
        LadderGameResults results = LadderGame.start(ladder, ladderPlayers, ladderRewards);

        Map<LadderPlayer, LadderReward> results1 = results.getResults();
        LadderPlayer ladderPlayerA = LadderPlayer.create("a");
        LadderPlayer ladderPlayerB = LadderPlayer.create("b");
        LadderPlayer ladderPlayerE = LadderPlayer.create("e");

        assertThat(results1.containsKey(ladderPlayerA)).isTrue();
        assertThat(results1.containsKey(ladderPlayerB)).isTrue();
        assertThat(results1.containsKey(ladderPlayerE)).isFalse();
    }

}