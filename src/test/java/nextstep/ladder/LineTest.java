package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    static class RandomFalse extends Random {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    }

    @Test
    @DisplayName("move_method_test")
    public void move_method_test(){
        Line line = new Line(5, new RandomLineStrategy(new RandomFalse()));


        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
        assertThat(line.move(2)).isEqualTo(2);
        assertThat(line.move(3)).isEqualTo(3);
        assertThat(line.move(4)).isEqualTo(4);
    }
}
