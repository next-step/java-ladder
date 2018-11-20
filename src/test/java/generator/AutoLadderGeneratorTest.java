package generator;

import model.Line;
import model.Participant;
import model.Positive;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AutoLadderGeneratorTest {

    private AutoLadderGenerator autoLadderGenerator;

    @Before
    public void setUp() throws Exception {
        autoLadderGenerator = new AutoLadderGenerator();
    }

    @Test
    public void getParticipants() {
        List<Participant> participants = Participant.getParticipants("pobi,crong,papa,jk");
        assertThat(participants.size()).isEqualTo(4);
    }

    @Test
    public void getLines() {
        List<Line> lines = autoLadderGenerator.getLines(Positive.of(5), 2);
        assertThat(lines.size()).isEqualTo(5);
    }
}