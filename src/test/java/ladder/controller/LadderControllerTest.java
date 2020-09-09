package ladder.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.WhenUtils;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Rewards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class LadderControllerTest {

    @DisplayName("input, output을 입력하지 않으면 에러 발생")
    @Test
    public void ladderControllerBuildFail() {

        assertThatNullPointerException().isThrownBy(() -> LadderController.builder()
                                                                          .build());
    }

    @DisplayName("Controller 생성 성공")
    @Test
    public void ladderControllerProcess() {

        assertThat(LadderController.builder()
                                   .input(WhenUtils.input("a,b,c", 5))
                                   .output(WhenUtils.output())
                                   .build()).isNotNull();
    }

    @DisplayName("일반적인 Controller 시나리오")
    @Test
    public void makeDomainObjects() {
        LadderController ladderController = LadderController.builder()
                                                            .input(WhenUtils.input("a,b,c", 5))
                                                            .output(WhenUtils.output())
                                                            .build();

        Participants participants = ladderController.makeParticipants();
        Ladder ladder = ladderController.makeLadder();
        Rewards rewards = ladderController.makeRewards();

        ladderController.printLadder(participants, ladder, rewards);
    }
}
