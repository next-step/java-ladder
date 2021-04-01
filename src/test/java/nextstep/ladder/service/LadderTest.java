package nextstep.ladder.service;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 생성 테스트")
    @Test
    void create_생성_테스트() {
        // given
        Participants participants = Participants.valueOf("12345,1234");
        Height height = Height.valueOf(1);
        // when
        Ladder ladder = Ladder.valueOf(participants, height);
        // then
        assertThat(ladder).isEqualTo(Ladder.valueOf(participants, height));
    }
}
