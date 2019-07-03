package ladderGame.util;

import ladderGame.domain.LadderResults;
import ladderGame.domain.Players;
import ladderGame.dto.LadderGameResult;
import ladderGame.dto.ResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultMapperTest {

    @Test
    @DisplayName("사용자와 결과를 결합해 DTO생성")
    void map() {
        Players players = Players.of(Arrays.asList("a", "b", "c","d"));
        LadderResults ladderResults = LadderResults.of(Arrays.asList("1000", "2000", "3000", "꽝"));

        LadderGameResult ladderGameResult = LadderResultMapper.map(players, ladderResults);

        ResultDto testResult = ladderGameResult.getResultSetByName("a");
        assertThat(testResult.getContent()).isEqualTo("1000");
    }
}