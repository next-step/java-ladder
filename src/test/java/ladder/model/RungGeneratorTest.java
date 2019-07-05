package ladder.model;

import ladder.util.RungGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RungGeneratorTest {

    private RungGenerator rungGenerator;

    @BeforeEach
    void setUp() {
        this.rungGenerator = new RungGenerator();
    }

    @Test
    void generate() {
        Boolean rung = rungGenerator.generate();

        assertThat(rung).isTrue();
    }

    @Test
    void generate2() {
        int countOfPlayers = 4;
        List<Boolean> rungs = rungGenerator.generate(countOfPlayers);

        assertThat(rungs.size()).isEqualTo(4);

        assertThat(rungs.get(0)).isTrue();
        assertThat(rungs.get(1)).isFalse();
        assertThat(rungs.get(2)).isTrue();
        assertThat(rungs.get(3)).isFalse();
    }

    @Test
    void getPreviousValue() {
        List<Boolean> emptyRungs = new ArrayList<>();
        assertThat(rungGenerator.getPreviousValue(emptyRungs)).isFalse();

        List<Boolean> trueRungList = Arrays.asList(Boolean.TRUE);
        assertThat(rungGenerator.getPreviousValue(trueRungList)).isTrue();

        List<Boolean> falseRungList = Arrays.asList(Boolean.FALSE);
        assertThat(rungGenerator.getPreviousValue(falseRungList)).isFalse();
    }

    @Test
    void oppositeRule() {
        assertThat(rungGenerator.oppositeRule(false)).isTrue();
        assertThat(rungGenerator.oppositeRule(true)).isFalse();
    }
}
