package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.hint.CreateLadderPointGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("게임 통합테스트를 진행한다.")
    void createLadder() {
        //given
        Players players = Players.of(NameSplitter.splitParticipationNames("a,b"));
        Rewards rewards = Rewards.of(NameSplitter.splitParticipationNames("1,2"));
        int ladderHeight = 10;
        Ladder ladder = Ladder.of(ladderHeight, players.getPlayersCount(), new CreateLadderPointGenerator());

        //when
        GameResults gameResults = LadderGame.runGame(players, rewards, ladder);

        assertThat(getPlayerGameName(gameResults, 0)).isEqualTo("a");
        assertThat(getPlayerGameName(gameResults, 1)).isEqualTo("b");
        assertThat(getRewardName(gameResults, 0)).isEqualTo("1");
        assertThat(getRewardName(gameResults, 1)).isEqualTo("2");
    }

    private String getRewardName(GameResults gameResults, int i) {
        return gameResults.getGameResults().get(i).getRewardName();
    }

    private String getPlayerGameName(GameResults gameResults, int i) {
        return gameResults.getGameResults().get(i).getPlayerGameName();
    }
}