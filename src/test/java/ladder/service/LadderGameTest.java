package ladder.service;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadder() {
        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        Ladder ladder = LadderGame.createLadder(new LadderSetting(5, 4), alwaysTrueStrategy);

        List<Bridge> steps = ladder.getSteps();

        assertThat(steps.size()).isEqualTo(5);
        steps.forEach(bridge -> {
            assertThat(bridge.getLines().size()).isEqualTo(3);
        });
    }

    @Test
    @DisplayName("사다리 게임 테스트")
    public void playGame() {
        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        Ladder ladder = LadderGame.createLadder(new LadderSetting(5, 4), alwaysTrueStrategy);

        String[] participantNames = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] outcomes = {"꽝", "5000", "꽝", "3000"};

        LadderGameData gameData = new LadderGameData(participantNames, outcomes);

        LadderResult ladderResult = LadderGame.playGame(ladder, gameData);

        String expectedOutcomes = "aaaa : 5000\nbbbb : 꽝\ncccc : 3000\ndddd : 꽝";

        assertThat(LadderGame.getOutcomeForParticipant(ladderResult, "all")).isEqualTo(expectedOutcomes);
    }

    @Test
    @DisplayName("입력받은 참가자의 결과를 찾는 테스트")
    public void getOutcomeForeParticipant() {
 ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        Ladder ladder = LadderGame.createLadder(new LadderSetting(5, 4), alwaysTrueStrategy);

        String[] participantNames = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] outcomes = {"꽝", "5000", "꽝", "3000"};

        LadderGameData gameData = new LadderGameData(participantNames, outcomes);

        LadderResult ladderResult = LadderGame.playGame(ladder, gameData);

        assertThat(LadderGame.getOutcomeForParticipant(ladderResult, "aaaa")).isEqualTo("5000");
    }

}
