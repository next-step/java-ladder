package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.domain.LadderResult.RESULT_CAN_NOT_BE_BLANK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("실행결과에 공백이 있으면 exception을 throw 한다.")
    void should_throw_exception_when_result_is_blank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(""))
                .withMessage(RESULT_CAN_NOT_BE_BLANK);
    }

}