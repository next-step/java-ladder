package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Line;
import step2.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    String input = "pobi,honux,crong,jk";

    Participants participants = new Participants(input);
    int countOfParticipants = participants.countOfParticipants();

    @Test
    void 라인_생성_참가자보다1작음() {
        Line line = new Line(1, countOfParticipants);
        int pointSize = countOfParticipants - 1;

        assertThat(line.getPointsLength()).isEqualTo(pointSize);
    }

    @Test
    void 시작포함_짝수순서_라인_생성() {
        Line line = new Line(0, countOfParticipants);

        assertThat(line.getPoints().get(0)).isTrue();
        assertThat(line.getPoints().get(1)).isFalse();
    }

    @Test
    void 홀수순서_라인_생성() {
        Line line = new Line(1, countOfParticipants);

        assertThat(line.getPoints().get(0)).isFalse();
        assertThat(line.getPoints().get(1)).isTrue();
    }
}
