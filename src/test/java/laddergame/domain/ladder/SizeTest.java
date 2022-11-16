package laddergame.domain.ladder;

import laddergame.domain.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeTest {
    @Test
    void 생성() {
        Size size = Size.calculate(5, new Players("a", "b", "c"));
        assertThat(size.height()).isEqualTo(5);
        assertThat(size.width()).isEqualTo(3);
    }
}
