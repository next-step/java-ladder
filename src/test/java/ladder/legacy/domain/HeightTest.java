package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    void height_creation_test() {
        String input = "5";

        int expectedHeight = Integer.parseInt(input);

        Height height = Height.of(input);
        assertThat(height.getValue()).isEqualTo(expectedHeight);
    }

    @Test
    void height_exception_test() {
        String input1 = "";
        assertThatThrownBy(() -> Height.of(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "-2";
        assertThatThrownBy(() -> Height.of(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
