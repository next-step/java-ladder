package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private BooleanGenerator booleanGenerator;

    @Before
    public void setUp() throws Exception {
        Level level = Level.findLevel("middle");
        this.booleanGenerator = new BooleanGeneratorWithLevel(level);
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = new LadderLine(sizeOfPerson, booleanGenerator);
        assertThat(ladderLine).isNotNull();
    }

    @Test
    public void move() {
        LadderLine line = new LadderLine(2, booleanGenerator);
        int result = line.move(0);
        assertThat(line).isNotNull();
        assertThat(result).isBetween(0, 1);
    }
}