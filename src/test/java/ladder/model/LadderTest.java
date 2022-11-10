package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사람수와 높이에 따라 사다리가 생성된다.")
    @Test
    void create() {
        Ladder ladder = new Ladder(3, 2, () -> true);

        assertThat(ladder.getLines()).hasSize(2);
        assertThat(ladder.getLines()).contains(new Line(3, () -> true));
    }
}
