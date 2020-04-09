package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {
    private static final String DELIMITER = ",";

    @DisplayName("결과 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = "a,b,c,d,e,f")
    void createResults(String resultString) {
        List<Result> resultList = Arrays.asList(resultString.split(DELIMITER)).stream()
                .map(Result::new)
                .collect(Collectors.toList());

        assertThatCode(() -> new Results(resultList, resultList.size()));
    }

    @DisplayName("유저 수와 결과 수가 같지 않을때 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = "a,b,c,d,e,f")
    void createFailByPersonSize(String resultString) {
        List<Result> resultList = Arrays.asList(resultString.split(DELIMITER)).stream()
                .map(Result::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> new Results(resultList, resultList.size() - 1));
    }
}
