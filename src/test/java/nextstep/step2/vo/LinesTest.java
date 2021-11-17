package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @DisplayName("Width Height 로 Lines를 반환한다.")
    @Test
    void createWithHeightAndWidthTest() {
        Height height = Height.create(5);
        Width width = Width.create(5);

        Lines lines = Lines.createWithHeightAndWidth(height, width, () -> true);

        assertThat(lines.getHeight()).isEqualTo(height);
        assertThat(lines.getWidth()).isEqualTo(width);
    }
}
