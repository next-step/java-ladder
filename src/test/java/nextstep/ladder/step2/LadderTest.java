package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("입력 받은 참여자와 사다리 높이에 해당하는 Ladder를 생성한다.")
    void create() {
        Ladder ladder = new Ladder();
        ladder.createLadder(6,5);
        assertThat(ladder.getLadderSize()).isEqualTo(5);
    }
}