package cc.oakk.ladder.model.size;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderHeightTest {
    @Test
    public void constructor_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(Integer.MIN_VALUE));
    }
}
