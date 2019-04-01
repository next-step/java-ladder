package domain.ladder;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void test_아래로_이동() {
        Point point = new Point(1, Direction.DOWN);
        assertThat(point.move())
                .isEqualTo(1);
    }

    @Test
    public void test_오른쪽으로_이동() {
        Point point = new Point(1, Direction.RIGHT);
        assertThat(point.move())
                .isEqualTo(2);
    }

    @Test
    public void test_왼쪽으로_이동() {
        Point point = new Point(1, Direction.LEFT);
        assertThat(point.move())
                .isEqualTo(0);
    }

    @Test
    public void test_첫번째_포인트_출력_4칸으로_채워짐() {
        Point right = new Point(0, Direction.RIGHT);
        assertThat(right.beautify())
                .isEqualTo("    |");
        Point down = new Point(0, Direction.DOWN);
        assertThat(down.beautify())
                .isEqualTo("    |");

        Point left = new Point(0, Direction.LEFT);
        assertThat(left.beautify())
                .isEqualTo("----|");
    }

    @Test
    public void test_첫번째를_제외한_나머지_출력_5칸으로_채워짐() {
        Point right = new Point(1, Direction.RIGHT);
        assertThat(right.beautify())
                .isEqualTo("     |");

        Point down = new Point(1, Direction.DOWN);
        assertThat(down.beautify())
                .isEqualTo("     |");

        Point left = new Point(1, Direction.LEFT);
        assertThat(left.beautify())
                .isEqualTo("-----|");
    }

    @Test
    public void test_동일성() {
        Point point = new Point(1, Direction.RIGHT);
        assertThat(point)
                .isEqualTo(new Point(1, Direction.RIGHT))
                .hasSameHashCodeAs(new Point(1, Direction.RIGHT))
                .isNotEqualTo(new Point(1, Direction.LEFT));
    }
}
