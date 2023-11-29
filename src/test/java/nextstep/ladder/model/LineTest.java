package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    static class AlwaysReturnTrue extends Random {

        @Override
        public boolean nextBoolean() {
            return true;
        }
    }
    
    @Test
    @DisplayName("사다리의 라인 하나를 생성한다")
    void line() {
        int countOfPerson = 5;
        Line line = new Line(countOfPerson, new AlwaysReturnTrue());

        assertThat(line.getPoints()).hasSize(countOfPerson - 1)
            .containsExactly(true, false, true, false);
    }
}