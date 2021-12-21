package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {

    @ParameterizedTest
    @EmptySource
    void 실행결과_empty_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> Results.of(input))
                .withMessage("실행결과를 입력해주세요");
    }

    @Test
    void 실행결과생성() {
        assertThat(Results.of("꽝,5000,꽝,3000").countOfResult()).isEqualTo(4);
    }
}
