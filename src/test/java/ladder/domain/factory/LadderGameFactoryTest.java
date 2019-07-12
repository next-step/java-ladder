package ladder.domain.factory;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameFactoryTest {

    @Test
    void createLadderGame() {

        String participantNames = "pobi,honux,crong,jk";
        String goals = "꽝,5000,꽝,3000";
        int height = 5;

        LadderGameInfo ladderGameInfo = new LadderGameInfo(participantNames, goals, height);
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderGameInfo);

        assertThat(ladderGame.getGameInfo()).isEqualTo(GameInfo.of(new Participants(participantNames), new Goals(goals)));
        assertThat(ladderGame.getLines().getLines().size()).isEqualTo(height);

    }
}