package nextstep.ladder;

import nextstep.ladder.domain.Ladders;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LaddersTest {
    @Test
    @DisplayName("높이 만큼의 Lines를 가지는 Ladder를 생성한다")
    void 높이_만큼의_Lines를_가지는_Ladder_생성() {
        Ladders ladders = new Ladders(4, 1);

        Assertions.assertThat(ladders.getLadderHeight()).isEqualTo(4);
    }
}
