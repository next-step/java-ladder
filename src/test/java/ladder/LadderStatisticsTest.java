package ladder;

import ladder.domain.LadderStatistics;
import ladder.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderStatisticsTest {
    @Test
    public void 올바른_참여자_Test(){
        HashMap playersResult = new HashMap();
        playersResult.put(new Player("crong"), "꽝");
        playersResult.put(new Player("pobi"), "1500");
        LadderStatistics ladderStatistics = new LadderStatistics(playersResult);
        assertThatThrownBy(() -> ladderStatistics.results(new Player("rupy")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여한 사람의 결과만 확인할 수 있습니다.");
    }
}
