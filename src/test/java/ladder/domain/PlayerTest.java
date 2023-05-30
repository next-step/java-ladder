package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("이름이 5자를 넘으면 예외를 던진다.")
    void 이름길이_제한() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("elizabeth");
        });
    }

    @Test
    @DisplayName("주어진 이름과 일치하는지 비교한다.")
    void 이름_비교() {
        Player player = new Player("ayla");
        assertThat(player.isNameEqual("ayla")).isTrue();
    }
}
