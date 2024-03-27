package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("[성공] 4명의 참가자와 높이 5의 사다리를 갖는 사다리 게임을 생성한다.")
    void 사다리_게임_생성() {
        LadderGame ladder = new LadderGame(Participants.of(List.of("pobi", "honux", "crong", "ny")), Ladder.of(4, 5));
        Assertions.assertThat(ladder.getParticipantsSize()).isEqualTo(4);
        Assertions.assertThat(ladder.getLadderHeight()).isEqualTo(5);
    }
}
