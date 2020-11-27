package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void create() {
        assertThat(new Line(Spork.of(true, false, true))).isNotNull();
    }

    /**
     * |-----|     |-----| 의 경우 첫번째는 1~2 구간에는 발판이 있고 2~3구간에는 발판이 없고 3~4 구간에는 발판이 있다.
     * 이를 Spork.of(true, false, true) 로 표현한다
     */
    private static class Spork {
        public static Spork of(boolean... existsSpoke) {
            return null;
        }
    }

    private static class Line {
        public Line(Spork spork) {
        }
    }
}
