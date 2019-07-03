package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LadderTest {

    @Test
    void generate_ladder() {
        int countOfPlayers = 4;
        int height = 5;
        Ladder ladder = Ladder.of(countOfPlayers, height);

        assertThat(ladder.getLayers().size()).isEqualTo(5);
    }
}
