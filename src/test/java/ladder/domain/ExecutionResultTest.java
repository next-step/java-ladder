package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExecutionResultTest {
    @DisplayName("실행결과 정상 생성 테스트")
    @Test
    void from() {
        assertThat(ExecutionResult.from("꽝,5000,꽝,3000")).isNotNull();
    }

    @DisplayName("실행결과 입력값이 존재하지 않는 경우 예외 발생 테스트")
    @Test
    void emptyException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> input = new ArrayList<>();
            ExecutionResult.from(input);
        });
    }

    @DisplayName("실행결과의 인덱스값으로 해당 위치의 결과값 확인 테스트")
    @Test
    void get() {
        assertThat(ExecutionResult.from("꽝,5000,꽝,3000").get(Position.from(1))).isEqualTo("5000");
    }
}