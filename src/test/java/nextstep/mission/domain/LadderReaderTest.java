package nextstep.mission.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderReaderTest {

    private static final int HEIGHT = 5;
    private static Participants participants = new Participants(Arrays.asList(
            new Participant("user1"),
            new Participant("user2"),
            new Participant("user3"),
            new Participant("user4")
    ));

    private LadderReader ladderReader;

    @BeforeEach
    public void init() {
        ladderReader = new LadderReader(Ladder.make(
                participants, HEIGHT
        ));
    }

    @Test
    void hasNext() {
        int count = 0;

        while (ladderReader.hasNext()) {
            ladderReader.getLine();
            count++;
        }

        assertThat(count).isEqualTo(HEIGHT);
    }

    @Test
    void getLine() {
        while (ladderReader.hasNext()) {
            assertThat(ladderReader.getLine()).isNotNull();
        }
    }
}
