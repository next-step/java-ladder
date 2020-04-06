package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
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
        participants.add(new Participant("참가자1"));
        participants.add(new Participant("참가자2"));
        participants.add(new Participant("참가자3"));

        List<String> results = new ArrayList<>();
        results.add("꽝");
        results.add("2000");
        results.add("꽝");
        results.add("꽝");
        LadderResult ladderResult = new LadderResult(results);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGame(participants, ladderResult);
        }).withMessage("실행 결과를 참가자의 수만큼 입력해주세요.");
    }
}
