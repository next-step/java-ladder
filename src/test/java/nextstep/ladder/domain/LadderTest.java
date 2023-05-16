package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("참여자와 사다리 높이가 주어졌을 때 사다리 높이 만큼의 Line 리스트를 생성한다.")
    @Test
    void when_ParticipantsAndHeightOfLadderIsGiven_Expect_HeightSizeOfLineList() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Height height = new Height(5);
        BridgeStrategy strategy = () -> true;

        List<Line> ladder = Ladder.of(participants).create(height, strategy);

        assertThat(ladder).hasSize(height.getHeight());
    }
}
