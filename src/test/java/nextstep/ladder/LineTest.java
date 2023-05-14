package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("Line_생성_테스트")
    public void Line_생성_테스트(){
        Participant participants = new Participant("test","test2");
        Line line = new Line(participants, new RandomLineStrategy());
        assertThat(participants.getParticipantSize()-1).isEqualTo(line.getPointSize());
    }
}
