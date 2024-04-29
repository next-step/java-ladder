package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {


    @DisplayName("참가자들이 양옆에 라인이 있을 경우 위치를 변경할 수 있다.")
    @Test
    void move() {
        Participant participantOne = new Participant("One");
        Participant participantTwo = new Participant("Two");
        List<Participant> participants = List.of(participantOne, participantTwo);
        LadderResult ladderResult = new LadderResult(participants);
        ladderResult.move(new Line(2, true));

        assertThat(ladderResult.getPosition(participantOne)).isEqualTo(1);
        assertThat(ladderResult.getPosition(participantTwo)).isEqualTo(0);
    }

    @DisplayName("상품 당첨 정보를 조회할 수 있다.")
    @Test
    void name() {
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
        Map<String, String> participantPrizeMap= ladderResult.mappingPrize(List.of("꽝","5000","꽝","3000"));
        String one = participantPrizeMap.get("One");
        String two = participantPrizeMap.get("Two");
        String three = participantPrizeMap.get("Three");
        String four = participantPrizeMap.get("Four");

        assertThat(one).isEqualTo("꽝");
        assertThat(two).isEqualTo("3000");
        assertThat(three).isEqualTo("꽝");
        assertThat(four).isEqualTo("5000");

    }
}
