package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RandomLineStrategyTest {


    static class RandomFalse extends Random {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    }

    static class RandomTrue extends Random{
        @Override
        public boolean nextBoolean(){
            return true;
        }
    }

    @Test
    @DisplayName("Random값과 직전 라인에 따른 라인 그리기 테스트")
    public void drawLine_테스트(){

        RandomLineStrategy lineTrue = new RandomLineStrategy(new RandomTrue());
        RandomLineStrategy linefalse = new RandomLineStrategy(new RandomFalse());

        assertThat(lineTrue.drawLine(0, 3)).isEqualTo(new Cross(false, true));
        assertThat(lineTrue.drawLine(1, 3)).isEqualTo(new Cross(true, false));
        assertThat(linefalse.drawLine(2, 3)).isEqualTo(new Cross(false, false));
    }
}
