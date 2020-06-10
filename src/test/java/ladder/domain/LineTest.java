package ladder.domain;

import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LineTest {

    @Test
    void createLine() {
        int countOfPerson = 5;

        Line line = Line.of(countOfPerson, new TrueLineStrategy());

        assertThat(line.size()).isEqualTo(countOfPerson);
    }
}