package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.*;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.BooleanRandomGeneratorStrategy;
import ladder.view.delegator.AllPrintResultDelegator;
import ladder.view.delegator.SinglePrintResultDelegator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    private static LadderGame ladderGame;

    @BeforeEach
    void init() {
        List<Line> testLadder = new ArrayList<>();
        testLadder.add(new Line(List.of(true, false)));
        testLadder.add(new Line(List.of(false, true)));

        Ladder ladder = new Ladder(testLadder);
        Participants participants = Participants.from(List.of(new Participant("java"), new Participant("lami"), new Participant("test")));
        LadderResults ladderResultValue = new LadderResults(List.of(LadderResult.from("꽝"), LadderResult.from("꽝"), LadderResult.from("당첨")));

        ladderGame = new LadderGame(ladder, participants, ladderResultValue);
    }

    @Test
    void 사다리_테스트() {
        Participant participant = new Participant("java");
        List<LadderResultPrint> process = ladderGame.process(participant);

        Assertions.assertThat(process.size()).isEqualTo(1);
        Assertions.assertThat(process.get(0).getParticipantName()).isEqualTo("java");
        Assertions.assertThat(process.get(0).getResult()).isEqualTo("당첨");
    }
}
