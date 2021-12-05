package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    void 높이를_생성한다() {
        //given
        Height height = Height.of(1);
        //when
        //then
        assertThat(height).isEqualTo(Height.of(1));
    }

    @Test
    void 높이를_생성한다2() {
        //given
        Height height = Height.of("1");
        //when
        //then
        assertThat(height).isEqualTo(Height.of("1"));
    }

    @Test
    void 높이에_음수를_입력하면_IllegalArgumentException이_발생한다() {
        //given
        //when & then
        assertThatThrownBy(() -> Height.of(-4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
