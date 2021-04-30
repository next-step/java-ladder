package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    public void from_lessThanMinWith() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderLine.from(1);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    public void nextIndex(String currentIndexInput, String expectedInput) {
        final int currentIndex = Integer.parseInt(currentIndexInput);
        final int expected = Integer.parseInt(expectedInput);

        final LadderLine ladderLine =
                new LadderLine(Arrays.asList(
                        new Point(Direction.RIGHT),
                        new Point(Direction.LEFT),
                        new Point(Direction.NONE),
                        new Point(Direction.NONE)
                ));

        final int actual = ladderLine.nextIndex(currentIndex);

        assertThat(actual).isEqualTo(expected);
    }
}
