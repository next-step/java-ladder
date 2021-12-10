package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    void 높이를_생성한다() {
        //given
        Height height = Height.of(1);
        //when & then
        assertThat(height).isEqualTo(Height.of(1));
    }

    @Test
    void 높이가_음수이면_IllegalArgumentException_이_발생한다() {
        //given
        //when & then
        assertThatThrownBy(() -> Height.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
