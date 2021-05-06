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
    @CsvSource(value = {"0:1", "1:0", "2:2", "3:3"}, delimiter = ':')
    public void move(String indexInput, String expectedInput) {
        final int index = Integer.parseInt(indexInput);
        final int expected = Integer.parseInt(expectedInput);

        final LadderLine ladderLine =
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.NONE),
                        new Point(3, Direction.NONE)
                ));

        final int actual = ladderLine.move(index);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void move_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final LadderLine ladderLine =
                    new LadderLine(Arrays.asList(
                            new Point(0, Direction.RIGHT),
                            new Point(1, Direction.LEFT),
                            new Point(2, Direction.NONE),
                            new Point(3, Direction.NONE)
                    ));

            ladderLine.move(5);
        });
    }
}
