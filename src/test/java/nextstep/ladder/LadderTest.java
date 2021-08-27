package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("입력 받은 참여자와 사다리 높이에 해당하는 Ladder를 생성한다.")
    void create() {
        assertThat(new Ladder(5,5).size()).isEqualTo(5);
    }
}