package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private Result sampleResult;

    @BeforeEach
    void setUp() {
        Map<User, Reward> relation = new HashMap<>();
        relation.put(new User("A"), new Reward("1등"));
        relation.put(new User("B"), new Reward("2등"));
        relation.put(new User("C"), new Reward("3등"));

        sampleResult = new Result(relation);
    }

    @Test
    @DisplayName("사람 조회")
    void testOnValidMember() {
        assertThat(sampleResult.responseForOne("A"))
                .isEqualTo("1등");
    }

    @Test
    @DisplayName("없는 사람 조회시 반환값")
    void testOnInvalidMember() {
        assertThat(sampleResult.responseForOne("No")).isEqualTo("포함되지 않은 인원입니다.");
    }

    @Test
    @DisplayName("모두 조회시의 반환 값")
    void testSearchAll() {
        Map<String, String> expected = new HashMap<>();
        expected.put("A", "1등");
        expected.put("B", "2등");
        expected.put("C", "3등");

        assertThat(sampleResult.responseForAll()).isEqualTo(expected);
    }
}
