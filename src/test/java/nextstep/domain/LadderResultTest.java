package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {
    @DisplayName("상품 당첨 정보를 조회할 수 있다.")
    @Test
    void createLadderResult() {
        Participant participantOne = new Participant("One",0);
        Participant participantTwo = new Participant("Two",1);
        Participant participantThree = new Participant("Three",2);
        Participant participantFour = new Participant("Four",3);
        Participants participants = new Participants(List.of(participantOne, participantTwo, participantThree, participantFour));

        Lines lines = new Lines(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        ));

        Ladder ladder = new Ladder(participants, lines);
        LadderResult ladderResult = ladder.createLadderResult(List.of("꽝", "5000", "꽝", "3000"));

        String one = ladderResult.get("One");
        String two = ladderResult.get("Two");
        String three = ladderResult.get("Three");
        String four = ladderResult.get("Four");

        assertThat(one).isEqualTo("꽝");
        assertThat(two).isEqualTo("3000");
        assertThat(three).isEqualTo("꽝");
        assertThat(four).isEqualTo("5000");

    }
}
