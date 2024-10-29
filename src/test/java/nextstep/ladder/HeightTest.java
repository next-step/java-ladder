package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    public void 사다리_높이가_0이하일시_예외를_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
    }
}
