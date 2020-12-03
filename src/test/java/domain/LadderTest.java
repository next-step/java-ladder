package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void ofTest() {
        Ladder ladder = Ladder.of(Length.of(3), Length.of(4));
        assertThat(ladder.getLines().mapLineOntoPoints().count()).isEqualTo(4);
    }
}
