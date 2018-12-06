package ladder2.model;

import org.junit.Test;
import java.util.Arrays;

import static ladder2.model.LadderLineTest.DEFAULT_LINE;
import static ladder2.model.ParticipantsTest.DEFAULT_PARTICIPANTS;
import static ladder2.util.DefaultLadderPointGeneratorTest.DEFAULT_LADDER_POINT_GENERATOR;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final Ladder DEFAULT_LADDER = Ladder.from(Arrays.asList(DEFAULT_LINE));

    @Test
    public void 생성() {
        assertThat(Ladder.from(5, DEFAULT_PARTICIPANTS, DEFAULT_LADDER_POINT_GENERATOR).getLines().size()).isEqualTo(5);
    }

    @Test()
    public void 참가자수와_일치_여부() {
        assertThat(DEFAULT_LADDER.getLines().get(0).getPoints().size()).isEqualTo(DEFAULT_PARTICIPANTS.size());
    }
}
