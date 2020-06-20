package ladder.domain.ladder;

import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LineTest {

    @Test
    @DisplayName("참가자 인원수에 따라 사다리 행(line) 생성")
    void createLine() {
        int countOfPerson = 5;

        Line line = Line.of(countOfPerson, new TrueLineStrategy());

        assertThat(line.size()).isEqualTo(countOfPerson);
    }
}
