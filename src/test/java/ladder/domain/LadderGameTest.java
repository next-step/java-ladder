package ladder.domain;

import ladder.domain.test.ForceMakePointsStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("[요구사항 1] ForceMakePointsStrategy를 통해 사다리를 만들고 게임을 진행하면 결과가 일직선에 해당하는 값으로 나와야 한다. (단, maximumLadderHeight가 짝수여야 함.)")
    void 요구사항_1() {
        // given : 일부러 참가자 이름과 결과 값이 동일하도록 설정
        List<String> executionResultsInput = Arrays.asList("Ari", "Bri", "Cri");
        ParticipantNames participantNames = new ParticipantNames(executionResultsInput);
        ExecutionResults executionResults = new ExecutionResults(executionResultsInput, participantNames.getParticipantsSize());
        int maximumLadderHeight = 2;

        // when : 일직선으로 결과가 나오게 하는 라인 제작 전략 채택 및 게임 진행
        List<Boolean> initializedPoints = Line.initializePoints(participantNames.getParticipantsSize(), ForceMakePointsStrategy.getInstance());
        Ladder ladder = new Ladder(initializedPoints, maximumLadderHeight);

        LadderGame ladderGame = new LadderGame(ladder, participantNames, executionResults);

        // then
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(0))).isEqualTo(executionResults.getEachResult(0));
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(1))).isEqualTo(executionResults.getEachResult(1));
        assertThat(ladderGame.findEachResult(participantNames.getParticipantNamesAsList().get(2))).isEqualTo(executionResults.getEachResult(2));
    }
}