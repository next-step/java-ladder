package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("참가자 수, 높이가 주어졌을 때 해당하는 사다리를 생성하는지 검증")
    @Test
    void constructTest() {
        Ladder ladder = new Ladder(10, 20);
        assertThat(ladder.getLines().size()).isEqualTo(20);
        assertThat(ladder.getLines().get(0).getPoints().size()).isEqualTo(9);
    }
}
