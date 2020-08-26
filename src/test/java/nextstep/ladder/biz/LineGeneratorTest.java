package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import nextstep.ladder.biz.LineGenerator;
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
    assertThat(LineGenerator.nextBoolean(Point.of(true))).isEqualTo(Point.of(false));
  }

  @Test
  void leastOneIsTrue() {
    List<Point> line = Arrays.asList(Point.of(false), Point.of(false));
    LineGenerator.leastOneIsTrue(line);

    assertThat(line)
        .isIn(Arrays.asList(Point.of(true), Point.of(false)),
            Arrays.asList(Point.of(false), Point.of(true)));
  }

  @Test
  void createBooleansBy2People() {
    assertThat(LineGenerator.form(2))
        .isIn(Arrays.asList(Point.of(true)),
            Arrays.asList(Point.of(false)));
  }

  @Test
  void createBooleansBy3People() {
    List<Point> line = LineGenerator.form(3);
    assertThat(line)
        .isIn(Arrays.asList(Point.of(true), Point.of(false)),
            Arrays.asList(Point.of(false), Point.of(true)));
  }
}
