package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameExecutionResultTest {
    @DisplayName("GameExecutionResult 입력값이 비어있을 경우")
    @Test
    void 객체가_비어있을_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameExecutionResult.create(Collections.emptyMap()))
                .withMessageMatching("GameExecutionResult is Empty");
    }

    @DisplayName("참여자 이름으로 사용자의 결과값 얻기")
    @ParameterizedTest
    @CsvSource({"user1,1000", "user2,꽝"})
    void 참여자_결과값_출력(String userName, String gameResult) {
        Map<String, String> executionResult = new LinkedHashMap<>();
        executionResult.put(userName, gameResult);
        assertThat(executionResult.get(userName)).isEqualTo(gameResult);
    }
}
