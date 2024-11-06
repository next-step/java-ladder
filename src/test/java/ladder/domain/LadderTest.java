package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadder() {
        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        Ladder ladder = Ladder.createSteps(new LadderSetting(5, 4), alwaysTrueStrategy);

        List<Bridge> steps = ladder.getSteps();

        assertThat(steps.size()).isEqualTo(5);

        for (Bridge bridge : steps) {
            assertThat(bridge.getLines().size()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("참가자의 사다리 타기 결과를 찾는 테스트")
    public void findOutcomeForParticipant() {
        ConnectionStrategy alwaysTrueStrategy = new FakeConnectionStrategy(true);

        Ladder ladder = Ladder.createSteps(new LadderSetting(5, 4), alwaysTrueStrategy);

        String[] participantNames = {"aaaa", "bbbb", "cccc", "dddd"};
        String[] outcomes = {"꽝", "5000", "꽝", "3000"};

        LadderGameData gameData = new LadderGameData(participantNames, outcomes);

        Map<String, String> expectedOutcomes = new LinkedHashMap<>();
        expectedOutcomes.put("aaaa", "5000");
        expectedOutcomes.put("bbbb", "꽝");
        expectedOutcomes.put("cccc", "3000");
        expectedOutcomes.put("dddd", "꽝");

        assertThat(ladder.findOutcomeForParticipant(gameData).getParticipantOutcomes())
                .isEqualTo(expectedOutcomes);
    }

}
