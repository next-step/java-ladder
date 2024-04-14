package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.LadderGameResult.NO_MATCHING_PRIZE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameResultTest {

    private final Participants participants = Participants.of(List.of("java", "dart", "go"));
    private final Prizes prizes = Prizes.of(List.of("연봉 1억", "연봉 동결", "스톡 옵션"), 3);

    @Test
    @DisplayName("LadderGameResult 객체 생성")
    void testLadderGameResult_generateLadderGameResult() {
        // given
        Participant java = participants.findParticipants("java").get(0);
        Participant dart = participants.findParticipants("dart").get(0);
        Participant go = participants.findParticipants("go").get(0);

        // when
        LadderGameResult ladderGameResult = LadderGameResult.generateLadderGameResult(getLadder(), participants, prizes);

        // then
        assertAll(
                "참가자별 상품 조회",
                () -> assertEquals(ladderGameResult.getPrizeOf(java), "스톡 옵션"),
                () -> assertEquals(ladderGameResult.getPrizeOf(dart), "연봉 1억"),
                () -> assertEquals(ladderGameResult.getPrizeOf(go), "연봉 동결")
        );
    }

    @Test
    @DisplayName("LadderGameResult에서 존재하지 않는 참가자의 결과 조회시, 에러 반환")
    void testLadderGameResult_getPrizeOfNonExistingParticipant_ShouldThrowException() {
        // given
        Participant python = Participant.of("lust", 0);
        LadderGameResult ladderGameResult = LadderGameResult.generateLadderGameResult(getLadder(), participants, prizes);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderGameResult.getPrizeOf(python);
        }).withMessageContaining(NO_MATCHING_PRIZE);
    }


    private Ladder getLadder() {
        List<Line> lines = new ArrayList<>();
        Line line1 = Line.of(
                            List.of(
                                    Point.of(false, true),
                                    Point.of(true, false),
                                    Point.of(false, false)
                            )
                    );
        Line line2 = Line.of(
                            List.of(
                                    Point.of(false, false),
                                    Point.of(false, true),
                                    Point.of(true, false)
                            )
                    );
        lines.add(line1);
        lines.add(line2);
        return new Ladder(lines);
    }

}
