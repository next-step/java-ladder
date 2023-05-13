package nextstep.ladder.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {

    static class StaticTrueRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    static class StaticFalseRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    }

    @Test
    @DisplayName("첫번째 포지션 라인 그리기 - true")
    void drawLineTrueTest() {
        DrawStrategy drawStrategy = new RandomStrategy(new StaticTrueRandom());

        assertThat(drawStrategy.drawFirstPosition())
                .isTrue();
    }

    @Test
    @DisplayName("첫번째 포지션 라인 그리기 - false")
    void drawLineFalseTest() {
        DrawStrategy drawStrategy = new RandomStrategy(new StaticFalseRandom());

        assertThat(drawStrategy.drawFirstPosition())
                .isFalse();
    }

    @Test
    @DisplayName("다음 포지션 라인 그리기 - true")
    void drawNextLineTrueTest() {
        DrawStrategy drawStrategy = new RandomStrategy(new StaticTrueRandom());

        assertThat(drawStrategy.drawNextPosition(false))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("다음 포지션 라인 그리기 - false")
    void drawNextLineFalseTest(boolean input) {
        DrawStrategy drawStrategy = new RandomStrategy(new StaticFalseRandom());

        assertThat(drawStrategy.drawNextPosition(input))
                .isFalse();
    }

    @Test
    @DisplayName("이전 라인이 그려졌을 때 false 그리기")
    void drawNextLineCheckPrevious() {
        DrawStrategy drawStrategy = new RandomStrategy();

        assertThat(drawStrategy.drawNextPosition(true))
                .isFalse();
    }

}
