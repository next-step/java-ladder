package cc.oakk.ladder.model.size;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderWidthTest {
    @Test
    public void constructor_ShouldThrow() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderWidth(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderWidth(Integer.MIN_VALUE));
    }
}
