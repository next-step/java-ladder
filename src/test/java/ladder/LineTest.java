package ladder;

import org.junit.jupiter.api.Test;
import ladder.domain.Line;
import ladder.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    String input = "pobi,honux,crong,jk";

    Participants participants = new Participants(input);
    int countOfParticipants = participants.countOfParticipants();

    @Test
    void 랜덤_라인_생성() {
        Line line = new Line(countOfParticipants);
        int pointSize = countOfParticipants - 1;

        assertThat(line.getPointsLength()).isEqualTo(pointSize);
        assertThat(line.getPoints().get(0).getPoint()).isIn(Boolean.TRUE, Boolean.FALSE);
    }

    @Test
    void 라인_이동_한명() {
        Line line = new Line(3);

        assertThat(line.move(2)).isIn(0, 1, -1);
    }
}
