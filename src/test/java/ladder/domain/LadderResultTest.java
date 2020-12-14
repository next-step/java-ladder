package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("입력받은 실행결과를 ','를 기준으로 나눈 배열을 반환한다.")
    void should_return_divided_result() {
        //Given
        String results = "꽝,5000,꽝,3000";

        //When
        LadderResult ladderResult = new LadderResult(results);

        //Then
        assertThat(ladderResult.containsAll(Arrays.asList("꽝", "5000", "꽝", "3000"))).isTrue();
    }

}