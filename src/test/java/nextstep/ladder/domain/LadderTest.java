package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("참여자와 사다리 높이가 주어졌을 때 사다리 높이 만큼의 Line 리스트를 생성한다.")
    @Test
    void when_ParticipantsAndHeightOfLadderIsGiven_Expect_HeightSizeOfLineList() {
        List<String> participants = List.of("pobi", "honux", "crong", "jk");
        int ladderHeight = 5;

        List<Line> ladder = Ladder.of(participants, ladderHeight);

        assertThat(ladder).hasSize(ladderHeight);
    }
}
