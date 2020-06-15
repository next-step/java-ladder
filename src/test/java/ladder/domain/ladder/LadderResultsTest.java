package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @Test
    @DisplayName("사다리 결과 생성 테스트")
    void LadderResultsCreateTest() {
        Map<Position, Position> map = new HashMap<>();
        map.put(new Position(1), new Position(2));
        LadderResults ladderResults = new LadderResults(map);
        Position resultPosition = ladderResults.getResultPosition(1);
        assertThat(resultPosition.getValue()).isEqualTo(2);
    }

}