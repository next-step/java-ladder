package ladder.service;

import ladder.domain.Bridge;
import ladder.domain.ConnectionStrategy;
import ladder.domain.FakeConnectionStrategy;
import ladder.domain.LadderSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadder() {
        LadderGame ladderGame = new LadderGame();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        List<Bridge> ladder = ladderGame.createLadder(new LadderSetting(4, 5), alwaysTrueStrategy);

        assertThat(ladder.size()).isEqualTo(5);
        ladder.forEach(bridge -> {
            assertThat(bridge.getConnections().size()).isEqualTo(3);
        });
    }

    @Test
    @DisplayName("입력받은 참가자의 결과를 찾는 테스트")
    public void getOutcomeForeParticipant() {
        LadderGame ladderGame = new LadderGame();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        List<Bridge> ladder = ladderGame.createLadder(new LadderSetting(4, 5), alwaysTrueStrategy);

        String[] participantNames = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] outcomes = {"꽝", "5000", "꽝", "3000"};

        ladderGame.playGame(participantNames, outcomes);

        assertThat(ladderGame.getOutcomeForParticipant("aaaa")).isEqualTo("5000");
    }

    @Test
    @DisplayName("사다리 게임 테스트")
    public void playGame() {
        LadderGame ladderGame = new LadderGame();

        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        List<Bridge> ladder = ladderGame.createLadder(new LadderSetting(4, 5), alwaysTrueStrategy);

        String[] participantNames = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] outcomes = {"꽝", "5000", "꽝", "3000"};

        ladderGame.playGame(participantNames, outcomes);

        Map<String, String> expectedOutcomes = new LinkedHashMap<>();
        expectedOutcomes.put("aaaa", "5000");
        expectedOutcomes.put("bbbb", "꽝");
        expectedOutcomes.put("cccc", "3000");
        expectedOutcomes.put("dddd", "꽝");


        assertThat(ladderGame.getParticipantOutcomes()).isEqualTo(expectedOutcomes);
    }

}
