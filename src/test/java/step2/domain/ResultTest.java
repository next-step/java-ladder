package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultTest {

    @ParameterizedTest
    @EmptySource
    void createResultTest(String emptyStr) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Result(emptyStr))
                .withMessage("실행 결과값은 공백일 수 없습니다.");
    }
}
