package nextstep.laddergame.domain.ladder;

import nextstep.laddergame.domain.participant.Participants;
import nextstep.laddergame.domain.reward.Rewards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("라인 목록 생성 함수")
    void create() {
        assertThat(new Lines(3, 4))
                .extracting("lines")
                .asList()
                .hasSize(3);
    }

    @Test
    @DisplayName("사다리 결과물 확인")
    void checkRewards() {
        final String targetName = "name";
        final Participants participants = new Participants("1,2," + targetName);
        final Rewards rewards = new Rewards(participants.getSize(), "1000,2000,3000");
        final Lines lines = new Lines(5, participants.getSize());

        Assertions.assertAll(
                () -> assertThat(lines.rewardOnePerson(participants, rewards, targetName))
                        .containsAnyOf("1000", "2000", "3000"),
                () -> assertThat(lines.rewardAll(participants, rewards))
                        .hasSize(3)
        );
    }
}
