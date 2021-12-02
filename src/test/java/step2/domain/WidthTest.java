package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WidthTest {

    @Test
    void 너비를_생성한다() {
        //given
        Width width = Width.of(10);
        //when & then
        assertThat(width).isEqualTo(Width.of(10));
    }
}
