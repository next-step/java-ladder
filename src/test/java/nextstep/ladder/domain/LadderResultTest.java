package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    Participants participants;

    @BeforeEach
    void setUp() {
        participants = new Participants("a,b,c,d");
    }

    @Test
    @DisplayName("입력한결과와 사다리결과를 조합하여 참여자의 결과 값에 저장")
    void combineLadderResult() {
        LadderExecutor ladderExecutor = new LadderExecutor(LinesTest.lines(), participants);
        ladderExecutor.executeLadder();

        LadderResult ladderResult = new LadderResult(ExecuteResultTest.EXECUTE_RESULT, ladderExecutor);
        ladderResult.combineLadderResult();

        assertThat(ladderResult.getPartitions().getParticipant(0).getResult()).isEqualTo("하겐다즈");
        assertThat(ladderResult.getPartitions().getParticipant(1).getResult()).isEqualTo("먹기만해");
        assertThat(ladderResult.getPartitions().getParticipant(2).getResult()).isEqualTo("먹어랏");
        assertThat(ladderResult.getPartitions().getParticipant(3).getResult()).isEqualTo("사줘라");
    }
}
