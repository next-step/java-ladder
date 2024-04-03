package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("")
    @Test
    void test() {
        Ladder ladder = Ladder.of(Lines.of(), Bridges.of());

        int position = ladder.search(0);

        assertThat(position).isEqualTo(3);
    }
}
