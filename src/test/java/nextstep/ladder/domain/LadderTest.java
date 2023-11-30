package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("전달받은 높이에 맞는 사다리를 만들어줍니다.")
    @Test
    void makeLadder() {
        // given
        // when
        Ladder ladder = Ladder.makeLadder(5, 4);
        // then
        Assertions.assertThat(ladder.getLines()).hasSize(4);
    }

}