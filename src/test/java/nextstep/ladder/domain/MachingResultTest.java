package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MachingResultTest {
    private Map<Integer, Integer> machingResultMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        machingResultMap.put(0,1);
        machingResultMap.put(1,3);
        machingResultMap.put(2,2);
        machingResultMap.put(3,0);
    }
    @Test
    @DisplayName("매칭결과에 따라 참여자와 입력한 결과를 저장")
    void map() {
        MachingResult machingResult = new MachingResult(machingResultMap);

        LadderResult ladderResult = machingResult.map(new Participants("a,b,c,d"), ExecuteResultTest.EXECUTE_RESULT);

        assertThat(ladderResult.getPlayerToReward().get(new Participant("a"))).isEqualTo("하겐다즈");
        assertThat(ladderResult.getPlayerToReward().get(new Participant("b"))).isEqualTo("먹어랏");
        assertThat(ladderResult.getPlayerToReward().get(new Participant("c"))).isEqualTo("사줘라");
        assertThat(ladderResult.getPlayerToReward().get(new Participant("d"))).isEqualTo("먹기만해");
    }
}
