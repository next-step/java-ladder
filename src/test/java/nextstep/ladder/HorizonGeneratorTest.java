package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class HorizonGeneratorTest {

  @Test
  void create() {
    Random random = new Random();
    System.out.println(random.nextBoolean());
    System.out.println(random.nextBoolean());
    System.out.println(random.nextBoolean());
  }

  @Test
  void nextBoolean() {
    assertThat(HorizonGenerator.nextBoolean(true)).isEqualTo(false);
  }

  @Test
  void leastOneIsTrue() {
    List<Boolean> bridges = Arrays.asList(false, false);
    HorizonGenerator.leastOneIsTrue(bridges);

    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }

  @Test
  void createBooleansBy2People() {
    assertThat(HorizonGenerator.form(2)).isEqualTo(Arrays.asList(true));
  }

  @Test
  void createBooleansBy3People() {
    List<Boolean> bridges = HorizonGenerator.form(3);
    assertThat(bridges)
        .isIn(Arrays.asList(true, false),
            Arrays.asList(false, true));
  }
}
