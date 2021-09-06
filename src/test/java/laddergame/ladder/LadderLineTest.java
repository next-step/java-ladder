package laddergame.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인은")
class LadderLineTest {

    @DisplayName("사람 수가 생성자의 매개변수다")
    @Test
    void create() {
        assertThat(new LadderLine(2)).isEqualTo(new LadderLine(2));
    }
}
