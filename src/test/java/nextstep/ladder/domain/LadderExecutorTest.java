package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderExecutorTest {

    Participants participants;

    @BeforeEach
    void setUp() {
        participants = new Participants("a,b,c,d");
    }

    @Test
    @DisplayName("사다리를 실행하고 결과를 수집")
    void moveAndCollectResult() {
        LadderExecutor ladderExecutor = new LadderExecutor(LinesTest.lines(), participants);
        MachingResult machingResult = ladderExecutor.play();

        assertThat(machingResult.getMachingResultMap().get(0)).isEqualTo(1);
        assertThat(machingResult.getMachingResultMap().get(1)).isEqualTo(0);
        assertThat(machingResult.getMachingResultMap().get(2)).isEqualTo(3);
        assertThat(machingResult.getMachingResultMap().get(3)).isEqualTo(2);
    }

}
