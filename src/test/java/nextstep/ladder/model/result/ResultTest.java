package nextstep.ladder.model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    
    @Test
    @DisplayName("결과 생성 테스트")
    void createResult() {
        Result result = new Result("꽝");
        assertThat(result.getValue()).isEqualTo("꽝");
    }
} 