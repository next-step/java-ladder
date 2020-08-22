package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class RandomBooleansTest {

  @Test
  void create() {
    Random random = new Random();
    System.out.println(random.nextBoolean());
  }

  @Test
  void createBooleansBy2People() {
    assertThat(RandomBooleans.form(2)).isEqualTo(Arrays.asList(true));
  }

  @Test
  void createBooleansBy3People() {
    assertThat(RandomBooleans.form(3))
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }

  @Test
  void nextBoolean() {
    assertThat(RandomBooleans.nextBoolean(true)).isEqualTo(false);
  }
}
