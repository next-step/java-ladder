package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("참가자 수와 사다리 높이를 전달하면 Ladder 객체를 생성한다.")
    @Test
    void LadderTest() {
        assertThat(Ladder.of(3, 3)).isInstanceOf(Ladder.class);
    }

    @DisplayName("참가자 목록을 전달하면 LadderResult객체를 반환한다.")
    @Test
    void LadderResultTest() {
        Ladder ladder = Ladder.of(3, 3);
        assertThat(ladder.getLadderResult(
                new Participants(List.of(
                    new Participant("test1"),
                    new Participant("test2"),
                    new Participant("test3"))),
                new Results(List.of("꽝", "당첨", "꽝")))).isInstanceOf(LadderResult.class);
    }
}
