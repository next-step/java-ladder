package nextstep.ladder.hint;

import nextstep.ladder.domain.Height;
import nextstep.ladder.service.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HintLadderTest {

    @DisplayName("사다리 높이 확인 테스트")
    @Test
    void create_height_테스트() {
        // given
        Participants participants = Participants.valueOf("user1", "user2");
        Height height = Height.valueOf(3);
        // when
        HintLadder ladder = HintLadder.valueOf(participants, height);
        List<HintLadderLine> ladderLine = ladder.lines();
        // then
        assertThat(ladderLine.size()).isEqualTo(3);
    }

    @DisplayName("사다리 타기 findEndPosition 테스트")
    @Test
    void findEndPosition_테스트() {
        // given
        Participants participants = Participants.valueOf("user1", "user2");
        Height height = Height.valueOf(3);
        // when
        HintLadder ladder = HintLadder.valueOf(participants, height);
        int endPosition = ladder.findEndPosition(1);
        // then
        assertThat(endPosition).isLessThan(2);
    }
}
