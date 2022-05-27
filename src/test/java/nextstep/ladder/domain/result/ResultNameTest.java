package nextstep.ladder.domain.result;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"5000", "꽝"})
    void createResultNameTest(String resultName) {
        new ResultName(resultName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5000", "꽝이에요"})
    void createResultNameTestFail(String resultName) {
        assertThatThrownBy(() -> new ResultName(resultName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
