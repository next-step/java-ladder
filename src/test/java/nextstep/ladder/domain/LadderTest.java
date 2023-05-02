package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder 높이와 사람 수를 가지고 생성한다.")
    void test01() {
        Ladder ladder = new Ladder(5, 4);

        assertThat(ladder.lines()).hasSize(4);
    }
}
