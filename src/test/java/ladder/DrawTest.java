package ladder;

import ladder.domain.Draw;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawTest {

    @DisplayName("true 값 다음은 무조건 false")
    @Test
    void getNextDrawBooleanValue() {
        assertThat(new Draw(new Draw(true))).isEqualTo(new Draw(false));
    }
}
