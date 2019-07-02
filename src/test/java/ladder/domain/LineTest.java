package ladder.domain;

import ladder.domain.generator.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("항상 true 발생시 라인 검증")
    void trueLine() {
        Line line = new Line(5, new StubPointGenerator(true));

        assertThat(line.getPoints().get(0).getDirection()).isSameAs(Direction.RIGHT);
        assertThat(line.getPoints().get(1).getDirection()).isSameAs(Direction.LEFT);
        assertThat(line.getPoints().get(2).getDirection()).isSameAs(Direction.EMPTY);
        assertThat(line.getPoints().get(3).getDirection()).isSameAs(Direction.RIGHT);
        assertThat(line.getPoints().get(4).getDirection()).isSameAs(Direction.LEFT);
    }

    @Test
    @DisplayName("항상 false 발생시 라인 검증")
    void falseLine() {
        Line line = new Line(5, new StubPointGenerator(false));

        assertThat(line.getPoints().get(0).getDirection()).isSameAs(Direction.EMPTY);
        assertThat(line.getPoints().get(1).getDirection()).isSameAs(Direction.EMPTY);
        assertThat(line.getPoints().get(2).getDirection()).isSameAs(Direction.EMPTY);
        assertThat(line.getPoints().get(3).getDirection()).isSameAs(Direction.EMPTY);
        assertThat(line.getPoints().get(4).getDirection()).isSameAs(Direction.EMPTY);
    }

    public static class StubPointGenerator implements PointGenerator {

        private boolean b;

        public StubPointGenerator(boolean b) {

            this.b = b;
        }

        @Override
        public boolean generate() {

            return b;
        }
    }
}