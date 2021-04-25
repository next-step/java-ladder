package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Size size = Size.of(5, 6);
    private Ladder ladder = Ladder.of(size, () -> true);

    @Test
    void 사다리생성() {
        assertThat(ladder).isEqualTo(Ladder.of(size, () -> true));
    }

    @Test
    void 사다리이동() {
    }
}
