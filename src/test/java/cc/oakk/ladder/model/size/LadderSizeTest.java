package cc.oakk.ladder.model.size;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderSizeTest {
    @Test
    public void constructor_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(0, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(0, 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(1, 0));

        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(Integer.MIN_VALUE, 10));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderSize(10, Integer.MIN_VALUE));
    }
}
