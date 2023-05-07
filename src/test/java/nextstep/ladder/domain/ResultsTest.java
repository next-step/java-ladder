package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    @DisplayName("라인별 결과 객체 생성 테스트")
    void createResultsTest() {
        List<Result> ints = List.of(new Result(0), new Result(1), new Result(2));
        Results results = new Results(ints);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(ints));
    }
}
