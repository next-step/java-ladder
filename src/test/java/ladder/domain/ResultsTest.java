package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    private Results sampleResults;

    @BeforeEach
    void setUp() {
        List<Result> results = new ArrayList<>();

        results.add(new Result(new User("A"), new Reward("1등")));
        results.add(new Result(new User("B"), new Reward("2등")));
        results.add(new Result(new User("C"), new Reward("3등")));

        sampleResults = new Results(results);
    }

    @Test
    @DisplayName("사람 조회")
    void testOnValidMember() {
        assertThat(sampleResults.responseForOne("A"))
                .isEqualTo("1등");
    }

    @Test
    @DisplayName("없는 사람 조회시 반환값")
    void testOnInvalidMember() {
        assertThat(sampleResults.responseForOne("No")).isEqualTo("포함되지 않은 인원입니다.");
    }

    @Test
    @DisplayName("모두 조회시의 반환 값")
    void testSearchAll() {
        Map<String, String> expected = new HashMap<>();
        expected.put("A", "1등");
        expected.put("B", "2등");
        expected.put("C", "3등");

        assertThat(sampleResults.responseForAll()).isEqualTo(expected);
    }
}
