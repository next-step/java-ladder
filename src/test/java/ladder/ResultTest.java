package ladder;

import ladder.domain.Result;
import ladder.exception.ResultBlankException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultTest {

    @Test
    @DisplayName("결과가 빌 경우 에러 발생한다")
    public void name_blank_error() {
        assertThatExceptionOfType(ResultBlankException.class)
            .isThrownBy(() -> {
                new Result("");
            }).withMessageMatching("결과는 빈값일 수 없습니다");
    }

}
