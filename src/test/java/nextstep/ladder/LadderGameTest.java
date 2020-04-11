package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 생성을 위해 입력받은 Participant와 실행결과의 개수가 다르면 Exception 처리를 한다.")
    void isSameCountParticipantAndResult() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("참가자1", 0));
        participants.add(new Participant("참가자2", 1));

        Ladder ladder = new Ladder(2, 5);

        List<String> results = new ArrayList<>();
        results.add("결과1");
        results.add("결과2");
        results.add("결과3");
        LadderResults ladderResults = new LadderResults(results);


        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGame(participants, ladder, ladderResults);
        }).withMessage(LadderGame.PARTICIPANTS_RESULTS_COUNT_ERROR);
    }
}
