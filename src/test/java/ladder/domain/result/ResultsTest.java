package ladder.domain.result;

import ladder.domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {
    @Test
    @DisplayName("결과를 생성한다")
    void valueOf() {
        String enteredResults = "꽝, 3000, 2000, 꽝";
        int countOfPerson = 4;
        assertThatCode(() -> Results.valueOf(enteredResults, countOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사람수와 결과 수가 다르면 에러를 뱉는다")
    void checkResultSize() {
        String enteredResults = "꽝, 3000, 2000, 꽝";
        int countOfPerson = 3;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Results.valueOf(enteredResults, countOfPerson));

    }
}
