package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    static class RandomTrue extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    @Test
    @DisplayName("Line_생성_테스트")
    public void Line_생성_테스트() {
        assertThat(new Line(2, new RandomLineStrategy(new RandomTrue()))).isEqualTo(new Line(2, new RandomLineStrategy(new RandomTrue())));
    }

    @Test
    @DisplayName("moveLine_method_test")
    public void moveLine_method_test(){
        Line line = new Line(5, new RandomLineStrategy(new RandomTrue()));


        assertThat(line.moveLine(0)).isEqualTo(1);
        assertThat(line.moveLine(1)).isEqualTo(0);
        assertThat(line.moveLine(2)).isEqualTo(3);
        assertThat(line.moveLine(3)).isEqualTo(2);
        assertThat(line.moveLine(4)).isEqualTo(4);
    }
}
