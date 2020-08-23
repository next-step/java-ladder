package nextstep.mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    public static final int HEIGHT = 5;
    public static final List<Participant> PARTICIPANTS = Arrays.asList(
            new Participant("user1"),
            new Participant("user2"),
            new Participant("user3"),
            new Participant("user4")
    );

    private Ladder ladder;

    @BeforeEach
    public void init() {
        ladder = Ladder.make(
                PARTICIPANTS, HEIGHT
        );
    }

    @Test
    void make() {
        assertThat(ladder).isEqualTo(Ladder.make(
                PARTICIPANTS, HEIGHT
        ));
    }

    @Test
    void hasNext() {
        int count = 0;

        while (ladder.hasNext()) {
            ladder.getLine();
            count++;
        }

        assertThat(count).isEqualTo(HEIGHT);
    }

    @Test
    void getLine() {
        while (ladder.hasNext()) {
            assertThat(ladder.getLine()).isNotNull();
        }
    }
}
