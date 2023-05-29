package ladder;

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
        LadderRequest request = new LadderRequest(Height.from(5), Width.from(5), new BooleanRandomGeneratorStrategy());
        Ladder ladder = Ladder.of(request);
        Participants participants = Participants.from(List.of(new Participant("java"), new Participant("lami")));
        LadderResultValue ladderResultValue = new LadderResultValue(List.of(LadderResult.from("꽝"), LadderResult.from("당첨")));

        ladderGame = new LadderGame(ladder, participants, ladderResultValue);
    }

    @Test
    void 사다리게임_진행_테스트_참가자_결과_출력() {
        PrintDelegator participantPosition = ladderGame.getParticipantPosition(new Participant("lami"));

        Assertions.assertThat(participantPosition.getDelegator()).isInstanceOf(SinglePrintResultDelegator.class);
    }

    @Test
    void 사다리게임_진행_테스트_모든_참가자_결과_출력() {
        PrintDelegator participantPosition = ladderGame.getParticipantPosition(new Participant("all"));

        Assertions.assertThat(participantPosition.getDelegator()).isInstanceOf(AllPrintResultDelegator.class);
    }
}
