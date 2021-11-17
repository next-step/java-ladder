package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("Width Height 로 Lines를 반환한다.")
    @Test
    void createWithHeightAndWidthTest() {
        Height height = Height.create(5);
        Width width = Width.create(5);

        Lines lines = Lines.createWithHeightANdWidth(height, width, () -> true);

        assertThat(lines.equalHeight(height)).isTrue();
        assertThat(lines.equalWidth(width)).isTrue();
    }
}
