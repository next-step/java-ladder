package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가자를 반환 한다.")
    @Test
    void getParticipantsInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        RandomStepStrategy randomStepStrategy = new RandomStepStrategy();

        // when
        Ladder ladder = Ladder.of(4, users, randomStepStrategy);

        // then
        assertThat(ladder.getParticipants()).contains("yang", "gang", "eee");
    }

    @DisplayName("사다리 정보를 반환한다.")
    @Test
    void getLadderInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");

        // when
        Ladder ladder = Ladder.of(7, users, new RandomStepStrategy());
        List<List<StepType>> ladderInfo = ladder.getLadderInfo();

        // then
        assertThat(ladderInfo).hasSize(7);
    }
}
