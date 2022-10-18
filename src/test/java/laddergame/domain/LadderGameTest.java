package laddergame.domain;

import laddergame.component.LadderFactory;
import laddergame.dto.LadderGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private final LadderFactory ladderFactory = new LadderFactory(numberOfColumns -> new LadderLine(List.of(true, false, true)));
    private final LadderGame ladderGame = new LadderGame(ladderFactory);

    @DisplayName("참가자 이름 목록과 사다리 높이를 전달하면, 사다리 게임 결과를 반환해야 한다.")
    @Test
    void run() {
        List<String> participantNameValues = List.of("a", "ab", "abc");
        int height = 2;
        List<ParticipantName> participantNames = List.of(
                new ParticipantName("a"),
                new ParticipantName("ab"),
                new ParticipantName("abc")
        );
        Ladder ladder = new Ladder(List.of(
                new LadderLine(List.of(true, false, true)),
                new LadderLine(List.of(true, false, true))
        ));
        assertThat(ladderGame.run(participantNameValues, height)).isEqualTo(new LadderGameResult(participantNames, ladder));
    }

}
