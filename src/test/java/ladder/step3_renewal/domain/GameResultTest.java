package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.controller.LadderGameController;
import step3_renewal.domain.GameResults;
import step3_renewal.domain.Ladder;
import step3_renewal.domain.Participants;
import step3_renewal.domain.Rewards;
import step3_renewal.utils.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 게임실행_테스트() {
        Participants participants = Participants.of(StringUtil.splitNames("yu,ra,won"));
        Rewards rewards = Rewards.of(StringUtil.splitNames("100,200,300"), participants.getParticipants().size());
        int ladderHeight = 4;

        Ladder ladder = Ladder.of(ladderHeight, participants);

        GameResults gameResults = LadderGameController.gameStart(participants, rewards, ladder);

        assertThat(gameResults.getGameResults().get(0).getParticipantName()).isEqualTo("yu");
        assertThat(gameResults.getGameResults().get(1).getParticipantName()).isEqualTo("ra");
        assertThat(gameResults.getGameResults().get(2).getParticipantName()).isEqualTo("won");
    }

}
