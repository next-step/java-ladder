package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {


    @Test
    @DisplayName("사다리 실행 결과(ladderResult)에 따라 입력 받은 결과를 mapping 하여 최종 결과를 반환한다.")
    void should_return_result() {
        //Given
        LadderGameInformation ladderGameInformation = new LadderGameInformation(
                "pobi,honux,crong,jk",
                "꽝,5000,꽝,3000");
        List<Integer> ladderResult = Arrays.asList(0, 1, 2, 3);

        //When
        LadderGameResult ladderGameResult = new LadderGameResult(ladderGameInformation, ladderResult);

        //Then
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("pobi", "꽝");
        expectedResult.put("honux", "5000");
        expectedResult.put("crong", "꽝");
        expectedResult.put("jk", "3000");
        assertThat(ladderGameResult.getResults()).isEqualToComparingOnlyGivenFields(expectedResult);
    }

}