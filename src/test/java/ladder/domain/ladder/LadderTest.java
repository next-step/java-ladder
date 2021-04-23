package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.domain.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Participants participants = Participants.of("a,b,c".split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);
        LineGenerateStrategy strategy = () -> true;

        // when
        Ladder ladder = Ladder.from(participants, ladderHeight, strategy);

        // then
        assertThat(ladder).isNotNull();
    }

}