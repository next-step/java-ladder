package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
