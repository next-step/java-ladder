package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Result result1;
    private Result result2;
    private Result result3;
    private Result result4;

    @BeforeEach
    void setUp() {
        result1 = new Result(new PlayerName("pobi"), new RewardName("꽝"));
        result2 = new Result(new PlayerName("crong"), new RewardName("3000"));
        result3 = new Result(new PlayerName("honux"), new RewardName("꽝"));
        result4 = new Result(new PlayerName("jk"), new RewardName("3000"));
    }

    @Test
    @DisplayName("결과목록을 생성한다")
    void create() {
        Results results = new Results(List.of(result1, result2, result3, result4));
        Results equalExpected = new Results(List.of(result1, result2, result3, result4));
        Results notEqualExpected = new Results(List.of(result2, result1, result3, result4));
        assertThat(results).isEqualTo(equalExpected);
        assertThat(results).isNotEqualTo(notEqualExpected);
    }

    @Test
    void values() {
        Results results = new Results(List.of(result1, result2, result3, result4));
        List<Result> actual = results.values();
        List<Result> expected = List.of(result1, result2, result3, result4);

        assertThat(actual).isEqualTo(expected);
    }
}
