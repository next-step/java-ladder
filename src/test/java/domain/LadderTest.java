package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @Test
    @DisplayName("of() test")
    void ofTest(){
        ladder = Ladder.init(3,3);
        assertThat(ladder.getLadderLines().size()).isEqualTo(3);
    }
}
