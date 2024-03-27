package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderJudgeTest {

    @Test
    @DisplayName("참가자와 사다리 결과를 알맞게 매칭시킨다")
    void judge() {
        List<Participant> participants = makeParticipants();
        LadderResult ladderResult = makeLadderResult();
        LadderGameResult gameResult = LadderJudge.judge(participants, makeResults(), ladderResult);

        assertThat(gameResult.get(participants.get(0))).isEqualTo("3");
        assertThat(gameResult.get(participants.get(1))).isEqualTo("1");
        assertThat(gameResult.get(participants.get(2))).isEqualTo("4");
        assertThat(gameResult.get(participants.get(3))).isEqualTo("2");
    }

    private List<String> makeResults() {
        return List.of("1", "2", "3", "4");
    }

    private static List<Participant> makeParticipants() {
        return List.of(
            Participant.from("a"),
            Participant.from("b"),
            Participant.from("c"),
            Participant.from("d")
        );
    }

    private LadderResult makeLadderResult() {
        Map<Integer, Integer> resultIndices = Map.of(
            0, 2,
            1, 0,
            2, 3,
            3, 1
        );
        return LadderResult.from(resultIndices);
    }
}
