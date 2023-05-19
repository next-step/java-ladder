package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Participants participants;
    private Height height;
    private BridgeStrategy strategy;


    @BeforeEach
    void setUp() {
        List<String> participants = List.of("pobi", "honux", "crong", "jk");
        this.participants = new Participants(participants);
        this.height = new Height(5);
        this.strategy = () -> true;
    }

    @DisplayName("참여자와 사다리 높이가 주어졌을 때 사다리 높이 만큼의 Line 리스트를 생성한다.")
    @Test
    void when_ParticipantsAndHeightOfLadderIsGiven_Expect_HeightSizeOfLineList() {
        Ladder ladder = Ladder.of(participants, height, strategy);
        assertThat(ladder.size()).isEqualTo(height.getHeight());
    }
}
