package ladder;

import ladder.domain.Results;
import ladder.exception.NullValueException;
import ladder.exception.PersonCountException;
import ladder.exception.ResultLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @DisplayName("실행결과 문자열와 인원수를 입력 받으면 실행결과 일급콜렉션 객체 Results를 생성한다")
    @Test
    void newResultTest() {
        assertThat(Results.of("꽝,5000,꽝,3000", 4)).isInstanceOf(Results.class);
    }

    @DisplayName("실행결과 문자열 데이터가 널이거나 길이가 0이면 예외를 던진다")
    @Test
    void throwExceptionTest() {
        assertThatThrownBy(() -> Results.of(null, 2)).isInstanceOf(NullValueException.class);
        assertThatThrownBy(() -> Results.of("", 2)).isInstanceOf(ResultLengthException.class);
        assertThatThrownBy(() -> Results.of("꽝,5000,꽝,3000", 2)).isInstanceOf(PersonCountException.class);
    }
}
