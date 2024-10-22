package ladder.domain;

import ladder.service.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.MembersTest.ms1;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("참여자와 높이를 입력하면 그에 맞는 사다리를 생성한다.")
    void 사다리_생성() {
        Lines ladders = LadderGame.getInstance().createLadders(ms1.getSize(), 5, () -> true);
        assertThat(ladders.getSize()).isEqualTo(5);
    }
}
