package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @ParameterizedTest
    @CsvSource({
            "5, 0",
            "5, -1",
            "0, 5",
            "-1, 5",
    })
    void testInvalid(int width, int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(width, height, () -> false));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(width, height, () -> true));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "1, 5",
            "5, 1",
            "4, 5",
            "5, 5",
            "5, 6",
    })
    void testLinkCount(int width, int height) {
        int expected = width / 2 * height;
        assertThat(Ladder.of(width, height, () -> true).getRows().stream()
                .flatMap(r -> r.getLinks().stream())
                .filter(b -> b)
                .count()).isEqualTo(expected);

        assertThat(Ladder.of(width, height, () -> false).getRows().stream()
                .flatMap(r -> r.getLinks().stream())
                .filter(b -> b)
                .count()).isEqualTo(0);
    }
}
