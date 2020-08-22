package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {

    @Test
    @DisplayName("null or empty 생성 시 예외")
    void testCreateLadderResultBlank() {
        assertThatThrownBy(() -> new LadderResult("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderResult(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderResult(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 정상 생성")
    void testCreateLadderResult() {
        String result = "꽝!!";
        assertThat(new LadderResult(result).getResult()).isEqualTo(result);
    }
}
