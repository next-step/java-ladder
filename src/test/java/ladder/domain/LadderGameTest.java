package ladder.domain;

import ladder.domain.test.ForceMakePointsStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("[요구사항 1] ForceMakePointsStrategy를 통해 사다리를 만들고 게임을 진행하면 결과가 일직선에 해당하는 값으로 나와야 한다. (단, maximumLadderHeight가 짝수여야 함.)")
    void 요구사항_1() {
        // given : 일부러 참가자 이름과 결과 값이 동일하도록 설정
        String[] executionResultsInput = {"Ari", "Bri", "Cri"};
        ParticipantNames participantNames = new ParticipantNames(executionResultsInput);
        ExecutionResults executionResults = new ExecutionResults(executionResultsInput, executionResultsInput.length);
        int maximumLadderHeight = 2;

        // when : 일직선으로 결과가 나오게 하는 라인 제작 전략 채택 및 게임 진행
        ForceMakePointsStrategy forceMakePointsStrategy = new ForceMakePointsStrategy();
        Ladder ladder = new Ladder(executionResultsInput.length, maximumLadderHeight, forceMakePointsStrategy);

        LadderGame ladderGame = new LadderGame(ladder, new ParticipantNames(executionResultsInput), executionResults);

        // then
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(0))).isEqualTo(executionResults.getEachResult(0));
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(1))).isEqualTo(executionResults.getEachResult(1));
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(2))).isEqualTo(executionResults.getEachResult(2));
    }
}