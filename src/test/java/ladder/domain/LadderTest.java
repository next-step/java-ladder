package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder.toString 테스트")
    void testToString() {
        int sizeOfPerson = 4;
        int height = 5;
        Line line = new Line(sizeOfPerson, () -> false);
        Ladder ladder = new Ladder(height, () -> line);
        assertThat(ladder.toString())
                .isEqualTo(System.lineSeparator() + "     |-----|     |-----|"
                        + System.lineSeparator() + "     |-----|     |-----|"
                        + System.lineSeparator() + "     |-----|     |-----|"
                        + System.lineSeparator() + "     |-----|     |-----|"
                        + System.lineSeparator() + "     |-----|     |-----|"
                );
    }
}
