package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.ExecutionResult;
import step3.domain.Person;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    @DisplayName("존재하지 않는 이름 예외처리")
    void notExistNameTest() {
        Map<Person, ExecutionResult> resultMap = new HashMap<>();
        resultMap.put(new Person("poby"), new ExecutionResult("꽝"));
        resultMap.put(new Person("jun"), new ExecutionResult("3000"));
        Result result = new Result(resultMap);
        assertThatThrownBy(() -> result.get(new Person("aa")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 값 매칭 테스트")
    void matchTest() {
        Map<Person, ExecutionResult> resultMap = new HashMap<>();
        resultMap.put(new Person("poby"), new ExecutionResult("꽝"));
        resultMap.put(new Person("jun"), new ExecutionResult("3000"));

        Result result = new Result(resultMap);
        assertThat(result.get(new Person("poby"))).isEqualTo(new ExecutionResult("꽝"));
    }

    @Test
    @DisplayName("모든 결과 값 매칭 테스트")
    void allMatchTest() {
        Map<Person, ExecutionResult> resultMap = new HashMap<>();
        resultMap.put(new Person("poby"), new ExecutionResult("꽝"));
        resultMap.put(new Person("jun"), new ExecutionResult("3000"));

        Result result = new Result(resultMap);
        assertThat(result.all().contains( new ExecutionResult("꽝"))).isTrue();
        assertThat(result.all().contains( new ExecutionResult("3000"))).isTrue();
        assertThat(result.all().contains( new ExecutionResult("500000"))).isFalse();
    }
}
