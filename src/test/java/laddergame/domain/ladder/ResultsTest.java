package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;
    private List<Result> resultList;
    private List<String> resultStrList;

    @BeforeEach
    void setUp() {
        resultList = Arrays.asList(new Result("꽝"), new Result("1000"), new Result("2000"));
        results = new Results(resultList);
    }

    @Test
    void 결과목록생성() {
        assertThat(results).isEqualTo(new Results(resultList));
    }

    @Test
    void 결과하나가져오기() {
        assertThat(results.getOne(0)).isEqualTo(resultList.get(0));
    }
}
