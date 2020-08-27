package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class LineGeneratorTest {

  @Test
  void create() {
    Random random = new Random();
    System.out.println(random.nextBoolean());
    System.out.println(random.nextBoolean());
    System.out.println(random.nextBoolean());
  }

  @Test
  void nextBoolean() {
    assertThat(LineGenerator.nextBoolean(Point.of(true), 0)).isEqualTo(Point.of(false, 0));
  }

  @Test
  void leastOneIsTrue() {
    List<Point> line = Arrays.asList(Point.of(false, 0), Point.of(false, 1));
    LineGenerator.leastOneIsTrue(line);

    assertThat(line)
        .isIn(Arrays.asList(Point.of(true, 0), Point.of(false, 1)),
            Arrays.asList(Point.of(false, 0), Point.of(true, 1)));
  }

  @Test
  void createBooleansBy2People() {
    assertThat(LineGenerator.form(2))
        .isIn(Arrays.asList(Point.of(true, 0)),
            Arrays.asList(Point.of(false, 0)));
  }

  @Test
  void createBooleansBy3People() {
    List<Point> line = LineGenerator.form(3);
    assertThat(line)
        .isIn(Arrays.asList(Point.of(true, 0), Point.of(false, 1)),
            Arrays.asList(Point.of(false, 0), Point.of(true, 1)));
  }
}
