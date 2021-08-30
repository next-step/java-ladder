package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Result;
import ladder.exception.NullValueException;
import ladder.exception.ResultLengthException;

class ResultTest {
    @DisplayName("실행결과 하나를 입력 받으면 실행결과 객체 Result를 생성한다")
    @Test
    void newResultTest() {
        assertThat(Result.from("꽝")).isInstanceOf(Result.class);
    }

    @DisplayName("실행결과 데이터가 널이거나 길이가 0이면 예외를 던진다")
    @Test
    void throwExceptionTest() {
        assertThatThrownBy(() -> Result.from(null)).isInstanceOf(NullValueException.class);
        assertThatThrownBy(() -> Result.from("")).isInstanceOf(ResultLengthException.class);
    }
}
