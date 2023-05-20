package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @Test
    @DisplayName("이름이 5자를 넘으면 예외를 던진다.")
    void 이름길이_제한() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("elizabeth");
        });
    }
}
