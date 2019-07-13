package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    void createLadder() {
        Ladder ladder = Ladder.of(5, 5);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
        assertThat(ladder.getLadder().get(0).size()).isEqualTo(5);
    }

    @Test
    void createLadderHeight101() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(101, 5));
    }

    @Test
    void createLadderHeight2() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(2, 5));
    }

    @Test
    void createLadderString() {
        Ladder ladder = Ladder.of(5, 5);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
        assertThat(ladder.getLadder().get(0).size()).isEqualTo(5);
    }

    @Test
    void getSize() {
        Ladder ladder = Ladder.of(5, 5);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
    }
}
