package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WidthTest {

    @Test
    void 너비를_생성한다() {
        //given
        Width width = Width.of(2);
        //when
        //then
        assertThat(width).isEqualTo(Width.of(2));
    }

    @Test
    void 너비가_음수이면_IllegalArgumentException_이_발생한다() {
        assertThatThrownBy(() -> Width.of(-2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
