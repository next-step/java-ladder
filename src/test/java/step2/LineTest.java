package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    String input = "pobi,honux,crong,jk";

    Participants participants = new Participants(input);
    int countOfParticipants = participants.countOfParticipants();

    @Test
    void 라인_생성() {
        Line line = new Line(countOfParticipants);

        assertThat(line.getPointsLength()).isEqualTo(3);

    }
}
