package ladder.domain.game;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;
import ladder.ui.InputView;
import ladder.ui.ResultView;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void LadderGameCreateLadderTest() {
        Lines ladder = LadderGame.createLadder(5, LadderHeight.inputHeight(5));

        List<Line> lineList = ladder.getLineList();
        assertThat(lineList.size()).isEqualTo(5);
    }

    @Test
    void LadderGameStartTest() {
        String[] playersName = {"a", "b", "c", "d"};
        String[] rewards = {"100", "꽝", "1000", "꽝"};

        LadderPlayers ladderPlayers = LadderPlayers.participate(playersName);
        LadderRewards ladderRewards = LadderRewards.inputRewards(rewards);
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);
        Lines ladder = LadderGame.createLadder(ladderPlayers.getPlayerCount(), ladderHeight);
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