package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LadderGameTest {
    static final String INPUT_USER_NAMES = "pobi,honux,crong,jk";
    static final String INPUT_USER_NAMES_INVALID_LENGTH = "toolongname,honux,crong,jk";
    static final int INPUT_LADDER_HEIGHT = 1;

    private LadderGame ladder;

    @BeforeEach
    void setUp() {
        ladder = new LadderGame(INPUT_USER_NAMES, INPUT_LADDER_HEIGHT);
    }

    @Test
    void generate() {
        LineStrategy strategy = new LineEvenStrategy();

        Line line = new Line(4, new LineEvenStrategy());
        ArrayList<Line> list = new ArrayList();
        list.add(line);
        Ladder ladderForm = new Ladder(list);

        assertThat(ladder.generate(strategy)).isEqualTo(ladderForm);
    }

    @Test
    void too_long_user_name() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LadderGame(INPUT_USER_NAMES_INVALID_LENGTH, INPUT_LADDER_HEIGHT);
        });
    }
}
