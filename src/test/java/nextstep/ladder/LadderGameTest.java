package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("[성공] 사다리 게임을 생성한다.")
    void 사다리_게임_생성() {
        Participants participants = Participants.of(List.of("pobi", "honux", "crong", "ny"));
        LadderGame ladder = new LadderGame(participants, Ladder.of(List.of(
                Line.of(List.of(true, false, true)),
                Line.of(List.of(false, true, false)),
                Line.of(List.of(true, false, false)),
                Line.of(List.of(false, true, false)),
                Line.of(List.of(true, false, true))
        )));

        Assertions.assertThat(ladder.getParticipantsSize()).isEqualTo(4);
        Assertions.assertThat(ladder.getLadderHeight()).isEqualTo(5);
    }
}
