package ladder.domain;

import ladder.domain.util.HorizontalGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.PlayersTest.PLAYERS1;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    private int playersCount;
    private HorizontalGenerator generator;
    private int verticalLadderSize;

    @BeforeEach
    void setUp() {
        playersCount = PLAYERS1.size();
        verticalLadderSize = 5;
        generator = () -> true;
    }

    @Test
    void create() {
        Lines actual = new Lines(PLAYERS1, verticalLadderSize, generator);
        Lines expected = new Lines(List.of(
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator),
                new Line(playersCount, generator)
        ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toLinesString() {
        Lines lines = new Lines(PLAYERS1, verticalLadderSize, generator);
        String actual = lines.toLinesString(PLAYERS1);
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
