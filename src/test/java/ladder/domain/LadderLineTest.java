package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    public void from_lessThanMinWith() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderLine.from(1);
        });
    }
}
