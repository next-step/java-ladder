package nextstep.mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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
        assertThatCode(() -> Ladder.make(
                PARTICIPANTS, HEIGHT
        )).doesNotThrowAnyException();
    }

    @Test
    void getHeight() {
        assertThat(HEIGHT).isEqualTo(ladder.getHeight());
    }

    @Test
    void getLine() {
        assertThat(ladder.getLine(0)).isNotNull();
        assertThat(ladder.getLine(1)).isNotNull();
        assertThat(ladder.getLine(2)).isNotNull();
        assertThat(ladder.getLine(3)).isNotNull();
        assertThat(ladder.getLine(4)).isNotNull();
    }
}
