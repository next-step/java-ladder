package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("참여자와 사다리 높이가 주어졌을 때 사다리 높이 만큼의 Line 리스트를 생성한다.")
    @Test
    void when_ParticipantsAndHeightOfLadderIsGiven_Expect_HeightSizeOfLineList() {
        List<String> participants = List.of("pobi", "honux", "crong", "jk");
        int ladderHeight = 5;

        List<Line> ladder = Ladder.of(participants, ladderHeight);

        assertThat(ladder).hasSize(ladderHeight);
    }

    @DisplayName("참여자가 1명 이하면 예외를 발생한다.")
    @Test
    void when_ParticipantsAreUnderTwo_Expects_ThrowException() {
        List<String> participants = List.of("pobi");
        int ladderHeight = 5;


        assertThatThrownBy(() -> Ladder.of(participants, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 1 미만이면 예외를 발생한다.")
    @Test
    void when_LadderHeightIsLessThanOne_Expects_ThrowException() {
        List<String> participants = List.of("pobi", "crong", "honux", "jk");
        int ladderHeight = 0;

        assertThatThrownBy(() -> Ladder.of(participants, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
