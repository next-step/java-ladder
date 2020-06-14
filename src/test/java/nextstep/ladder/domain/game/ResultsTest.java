package nextstep.ladder.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @MethodSource("결과셋_생성")
    @ParameterizedTest
    @DisplayName("results 생성 테스트")
    void create(List<Result> resultList) {
        Results results = new Results(resultList);
        assertThat(results.size()).isEqualTo(resultList.size());
    }

    private static Stream<Arguments> 결과셋_생성() {

        List<Result> resultList = Arrays.asList(Result.from("꽝"), Result.from("50000"), Result.from("꽝"), Result.from("10000"));

        return Stream.of(Arguments.of(resultList));
    }
}
