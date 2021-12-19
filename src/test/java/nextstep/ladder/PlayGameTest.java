package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayGameTest {
    @Test
    @DisplayName("PlayGame 테스트")
    public void PlayGameTest() {
        Participants participants = Participants.of("A,B,C,D,E,F");
        Compensations compensations = Compensations.of("꽝,꽝,우승,꽝,꽝,꽝", participants.getParticipantsSize());
        Participant participantWantResult = Participant.of("A", 0);
        Line lineA = Line.ofString("right,left,right,left,none,none");
        Line lineB = Line.ofString("none,right,left,right,left,none");
        Line lineC = Line.ofString("right,left,none,right,left,none");

        List<Line> lines = new ArrayList<>();
        lines.add(lineA);
        lines.add(lineB);
        lines.add(lineC);
        Ladder ladder = Ladder.ofLines(lines);

        PlayGame playGame = PlayGame.of(participants, compensations);
        HashMap<String, String> resultPlayOne = playGame.playGame(participantWantResult, ladder);

        assertThat(resultPlayOne.get("A")).isEqualTo("우승");

        assertThatThrownBy(() -> {
            playGame.playGame(Participant.of("q", 0), ladder);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("해당 참가자가 없습니다.");

        HashMap<String, String> resultAll = playGame.playGame(Participant.of("all", 0), ladder);
        assertThat(resultAll.get("A")).isEqualTo("우승");
    }
}
