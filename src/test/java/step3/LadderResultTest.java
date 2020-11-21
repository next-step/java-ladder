package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.ladder.LadderResults;
import step3.domain.ladder.dto.LadderResultDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {


    @DisplayName("실행결과 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = "꽝,5000,꽝,3000")
    void makeLadderResult(String inputResult) {
        LadderResults ladderResults = LadderResults.of(inputResult);

        LadderResultDTO resultDTO = ladderResults.resultByPoint(0);
        assertThat(resultDTO.getResult()).isEqualTo("꽝");

        resultDTO = ladderResults.resultByPoint(1);
        assertThat(resultDTO.getResult()).isEqualTo("5000");

        resultDTO = ladderResults.resultByPoint(2);
        assertThat(resultDTO.getResult()).isEqualTo("꽝");

        resultDTO = ladderResults.resultByPoint(3);
        assertThat(resultDTO.getResult()).isEqualTo("3000");
    }

    @DisplayName("실행결과 입력 예외 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void makeLadderResultNullAndEmpty(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    LadderResults ladderResults = LadderResults.of(input);
                }).withMessage(LadderResults.ERROR_INVALID_PARAMETER);
    }
}
