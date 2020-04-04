package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("pobi"));
        participants.add(new Participant("honux"));
        participants.add(new Participant("crong"));
        participants.add(new Participant("jk"));
        int height = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderGame.createLadder(participants, height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }

    @Test
    @DisplayName("사다리의 Point(참여자 수)는 2명 이상이어야 한다.")
    void assertLadderWidth() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("pobi"));
        int height = 5;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderGame.createLadder(participants, height);
        }).withMessage(Line.POINT_COUNT_ERROR);
    }
}
