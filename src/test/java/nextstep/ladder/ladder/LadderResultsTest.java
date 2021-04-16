package nextstep.ladder.ladder;

import nextstep.ladder.entity.ladder.LadderResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {

    private LadderResults ladderResults;
    private final String resultsInput = "5000,꽝,10000,꽝";

    @BeforeEach
    void setup() {
        ladderResults = new LadderResults(resultsInput);
    }

    @Test
    @DisplayName("사다리 게임 결과 리스트 생성")
    public void ladderResultCreate(){
        assertThat(ladderResults.equals(new LadderResults(resultsInput))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:5000", "1:꽝", "2:10000", "3:꽝"}, delimiter = ':')
    @DisplayName("사다리 게임 종료 위치 결과 가져오기")
    public void ladderPositionResult(int startPosition, String result){
        assertThat(ladderResults.positionResult(startPosition).equals(result)).isTrue();
    }
}
