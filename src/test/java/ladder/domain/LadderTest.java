package ladder.domain;

import ladder.domain.util.HorizontalGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {


    private Players players;
    private HorizontalGenerator horizontalGenerator;
    private int verticalLadderSize;

    @BeforeEach
    void setUp() {
        players = new Players("pobi,crong,honux,jk");
        horizontalGenerator = () -> true;
        verticalLadderSize = 5;
    }

    @Test
    void create() {
        Ladder actual = new Ladder(players, verticalLadderSize, horizontalGenerator);
        Ladder expected = new Ladder(players, List.of(
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator),
                new Line(4, horizontalGenerator)
                ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toStringLadder() {
        Ladder ladder = new Ladder(players, verticalLadderSize, horizontalGenerator);
        String actual = ladder.toLadderString();
        String expected = new StringBuilder()
                .append(" pobi crong honux    jk\n")
                .append("     |-----|     |-----|\n")
                .append("     |-----|     |-----|\n")
                .append("     |-----|     |-----|\n")
                .append("     |-----|     |-----|\n")
                .append("     |-----|     |-----|")
                .toString();

        assertThat(actual).isEqualTo(expected);
    }
}
