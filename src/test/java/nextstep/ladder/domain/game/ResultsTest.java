package nextstep.ladder.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {

    @MethodSource("결과셋_생성")
    @ParameterizedTest
    @DisplayName("results 생성 테스트")
    void create(List<String> resultList) {
        Results results = new Results(resultList);
        assertThat(results).isEqualTo(new Results(resultList));
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("results 생성 테스트")
    void exception(List<String> resultList) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results(resultList));
    }

    @MethodSource("결과셋_생성")
    @ParameterizedTest
    @DisplayName("get 검증 테스트")
    void get(List<String> resultList) {
        Results results = new Results(resultList);
        assertThat(results.get(0)).isEqualTo(Result.from(resultList.get(0)));
    }

    private static Stream<Arguments> 결과셋_생성() {
        List<String> resultList = Arrays.asList("꽝", "50000", "꽝", "10000");
        return Stream.of(Arguments.of(resultList));
    }
}
