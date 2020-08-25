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
    assertThat(LineGenerator.nextBoolean(true)).isEqualTo(false);
  }

  @Test
  void leastOneIsTrue() {
    List<Boolean> bridges = Arrays.asList(false, false);
    LineGenerator.leastOneIsTrue(bridges);

    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }

  @Test
  void createBooleansBy2People() {
    assertThat(LineGenerator.form(2))
        .isIn(Arrays.asList(true),
            Arrays.asList(false));
  }

  @Test
  void createBooleansBy3People() {
    List<Boolean> bridges = LineGenerator.form(3);
    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }
}
