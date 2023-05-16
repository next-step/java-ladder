package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 값비교() {
        assertAll(
            () -> assertThat(Delimiter.HORIZONTAL_LINE.value()).isEqualTo("-"),
            () -> assertThat(Delimiter.LINE_SEPARATOR.value()).isEqualTo("\n"),
            () -> assertThat(Delimiter.VERTICAL_LINE.value()).isEqualTo("|"),
            () -> assertThat(Delimiter.WHITE_SPACE.value()).isEqualTo(" ")
        );
    }

}