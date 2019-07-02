package ladder.model;

import ladder.util.RungGenerator;
import org.junit.jupiter.api.Test;

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
}
