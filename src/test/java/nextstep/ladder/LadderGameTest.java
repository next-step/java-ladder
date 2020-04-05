package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    @DisplayName("입력받은 참가자 이름(width - 1)과 사다리 높이(height) 만큼의 사다리가 생성되는지 확인한다.")
    void createLadder() {
        Ladder ladder = new Ladder(4, 5);

        assertThat(ladder.getWidth()).isEqualTo(3);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
