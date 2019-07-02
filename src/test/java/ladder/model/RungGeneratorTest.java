package ladder.model;

import ladder.util.RungGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RungGeneratorTest {

    @Test
    void generate() {
        Rung rung = RungGenerator.generate();

        assertThat(rung.isRung()).isTrue();
    }

    @Test
    void generate2() {
        int countOfPlayers = 4;
        List<Rung> rungs = RungGenerator.generate(countOfPlayers);

        assertThat(rungs.size()).isEqualTo(4);
    }

    @Test
    void getPreviousValue() {
        List<Rung> emptyRungs = new ArrayList<>();
        assertThat(RungGenerator.getPreviousValue(emptyRungs)).isFalse();

        List<Rung> trueRungList = Arrays.asList(new Rung(true));
        assertThat(RungGenerator.getPreviousValue(trueRungList)).isTrue();

        List<Rung> falseRungList = Arrays.asList(new Rung(false));
        assertThat(RungGenerator.getPreviousValue(falseRungList)).isFalse();
    }

    @Test
    void oppositeRule() {
        assertThat(RungGenerator.oppositeRule(false)).isTrue();
        assertThat(RungGenerator.oppositeRule(true)).isFalse();
    }
}
