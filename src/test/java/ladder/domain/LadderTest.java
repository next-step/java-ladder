package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("참가자 수와 결과 배열, 사다리 높이를 전달하면 Ladder 객체를 생성한다.")
    @Test
    void LadderTest() {
        assertThat(Ladder.of(3, new String[]{"꽝", "당첨", "꽝"}, 3)).isInstanceOf(Ladder.class);
    }

    @DisplayName("참가자 수와 결과 배열의 수가 일치하지 않으면 IllegalArgumentException을 던진다.")
    @Test
    void ladderExceptionTest() {
        assertThatThrownBy(() -> Ladder.of(3, new String[]{"꽝", "당첨"}, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 목록을 전달하면 LadderResult객체를 반환한다.")
    @Test
    void LadderResultTest() {
        Ladder ladder = Ladder.of(3, new String[]{"꽝", "당첨", "꽝"}, 3);
        assertThat(ladder.getLadderResult(new Participants(List.of(
                new Participant("test1"),
                new Participant("test2"),
                new Participant("test3")
        )))).isInstanceOf(LadderResult.class);
    }
}
