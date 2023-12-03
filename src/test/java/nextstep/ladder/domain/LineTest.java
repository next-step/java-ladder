package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.RowLinePositions;
import nextstep.ladder.domain.participant.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

@DisplayName("하나의 사다리 라인 테스트")
public class LineTest {

    private String[] participants = {"pobi","honux","crong","jk"};

    @DisplayName("사다리들을 가지고 있는 하나의 라인 객체를 생성한다.")
    @Test
    void line() {
        Assertions.assertThat(new Line(participants)).isInstanceOf(Line.class);
    }

    @Test
    void moveParticipant() {
        Participant participant = new Participant("muel", 0);
        RowLinePositions positions = new RowLinePositions(
                List.of(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE),
                3);
        Line line = new Line(3, positions);
        line.movableParticipant(participant);

        System.out.println(participant);
    }
}
