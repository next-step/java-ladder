package ladder.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LengthTest {
    @Test
    public void 길이는_1_보다_작으면_IllegalArgumentException() {
        // given
        int length = 0;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Length(length));
    }
}
