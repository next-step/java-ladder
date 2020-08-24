package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    List<Boolean> bridges = RandomBooleans.form(3);
    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }

  @Test
  void oneIsTrue() {
    List<Boolean> bridges = Arrays.asList(false, false);
    RandomBooleans.oneIsTrue(bridges);

    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }

  @Test
  void nextBoolean() {
    assertThat(RandomBooleans.nextBoolean(true)).isEqualTo(false);
  }
}
