package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultsTest {

    @ParameterizedTest
    @EmptySource
    void createResultsTest(String emptyStr) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Results.of(emptyStr))
                .withMessage("실행 결과값은 공백일 수 없습니다.");
    }
}
