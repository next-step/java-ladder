package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LadderTest {
    @Test
    void init() {
        // given
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = new Ladder(countOfPerson, height);
        // when & then
        assertThat(ladder.ladderHeight()).isEqualTo(height);
    }

    @Test
    void validate() {
        // given
        int height = 0;
        int countOfPerson = 5;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ladder(countOfPerson, height));
    }
}
