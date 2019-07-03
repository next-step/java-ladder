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
        Rung rung = rungGenerator.generate();

        assertThat(rung.isRung()).isTrue();
    }

    @Test
    void generate2() {
        int countOfPlayers = 4;
        List<Rung> rungs = rungGenerator.generate(countOfPlayers);

        assertThat(rungs.size()).isEqualTo(4);

        assertThat(rungs.get(0).isRung()).isTrue();
        assertThat(rungs.get(1).isRung()).isFalse();
        assertThat(rungs.get(2).isRung()).isTrue();
        assertThat(rungs.get(3).isRung()).isFalse();
    }

    @Test
    void getPreviousValue() {
        List<Rung> emptyRungs = new ArrayList<>();
        assertThat(rungGenerator.getPreviousValue(emptyRungs)).isFalse();

        List<Rung> trueRungList = Arrays.asList(new Rung(true));
        assertThat(rungGenerator.getPreviousValue(trueRungList)).isTrue();

        List<Rung> falseRungList = Arrays.asList(new Rung(false));
        assertThat(rungGenerator.getPreviousValue(falseRungList)).isFalse();
    }

    @Test
    void oppositeRule() {
        assertThat(rungGenerator.oppositeRule(false)).isTrue();
        assertThat(rungGenerator.oppositeRule(true)).isFalse();
    }
}
