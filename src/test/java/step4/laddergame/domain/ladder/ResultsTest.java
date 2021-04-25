package step4.laddergame.domain.ladder;

import com.google.common.collect.Streams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;
    private List<Result> resultList;

    @BeforeEach
    void setUp() {
        resultList = Arrays.asList(Result.of("꽝"), Result.of("1000"), Result.of("2000"));
        results = new Results(resultList);
    }

    @Test
    void 결과목록생성() {
        assertThat(results).isEqualTo(new Results(resultList));
    }

    @Test
    void 이동결과매치() {
        List<Integer> moveResult = Arrays.asList(1, 0, 2);
        List<Result> matchList = results.match(moveResult);
        Streams.forEachPair(matchList.stream(), moveResult.stream(), (matching, moveIndex) -> {
            assertThat(matching).isEqualTo(resultList.get(moveIndex));
        });
    }
}
