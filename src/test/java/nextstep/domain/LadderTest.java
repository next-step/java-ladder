package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {


    @DisplayName("사다리 타기 결과를 만들 수 있다.")
    @Test
    void createLadderResult() {
        Participant participantOne = new Participant("One");
        Participant participantTwo = new Participant("Two");
        Participant participantThree = new Participant("Three");
        Participant participantFour = new Participant("Four");
        Participants participants = new Participants(List.of(participantOne, participantTwo, participantThree, participantFour));

        Lines lines = new Lines(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        ));

        Ladder ladder = new Ladder(participants, lines);

        LadderResult ladderResult = ladder.createLadderResult();
        Integer onePosition = ladderResult.getPosition(participantOne);
        Integer twoPosition = ladderResult.getPosition(participantTwo);
        Integer threePosition = ladderResult.getPosition(participantThree);
        Integer fourPosition = ladderResult.getPosition(participantFour);

        assertThat(onePosition).isEqualTo(0);
        assertThat(twoPosition).isEqualTo(3);
        assertThat(threePosition).isEqualTo(2);
        assertThat(fourPosition).isEqualTo(1);
    }
}
