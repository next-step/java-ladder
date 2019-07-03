package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class HeightTest {
    @Test
    void 입력받은_사다리의_높이가_1보다_작을_경우_예외가_발생한다() {
        int inputHeight = Height.MINIMUM_LADDER_HEIGHT - 1;

        assertThatExceptionOfType(IllegalArgumentException.class)
               .isThrownBy(() -> {
                   Height.from(inputHeight);
               }).withMessage(Height.ALERT_MINIMUM_LADDER_HEIGHT);
    }
}
