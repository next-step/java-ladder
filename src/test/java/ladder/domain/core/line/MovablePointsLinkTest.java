package ladder.domain.core.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.ui.LadderDisplay;

import static org.assertj.core.api.Assertions.assertThat;

class MovablePointsLinkTest {
    @DisplayName("Line 생성시 무조건 링크를 생성하는 경우")
    @Test
    void allLink() {
        MovablePoints line = MovablePoints.of(()-> true, 5);

        assertThat(line.getPoint(0).linkingPoint()).isEqualTo(line.getPoint(1));
        assertThat(line.getPoint(2).linkingPoint()).isEqualTo(line.getPoint(3));
        assertThat(line.getPoint(4).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.collectLinkState()).containsExactly(true, false, true, false, false);
    }

    @DisplayName("Line 생성시 무조건 링크를 생성하지 않는 경우")
    @Test
    void allNotLink() {
        MovablePoints line = MovablePoints.of(()-> false, 5);

        assertThat(line.getPoint(0).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(1).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(2).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(3).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(4).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.collectLinkState()).containsExactly(false, false, false, false, false);
    }

    @Test
    void name() {
        Participants participants = new Participants("a,b,c,d,e");
        ParticipantsLine participantsLine = new ParticipantsLine(participants);
        participants.getCount();
        MovableLines movableLines = MovableLines.of(5, participants.getCount());

        LadderDisplay.display(participantsLine.toDisplayResult());
        LadderDisplay.display(movableLines.toDisplayResult());
    }
}