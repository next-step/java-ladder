package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LambdaTest {

  private List<Integer> numbers;

  @BeforeEach
  public void setup() {
    numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
  }

  @Test
  public void printAllOld() throws Exception {
    Lambda.printAllOld(numbers);
  }

  @Test
  public void printAllLambda() throws Exception {
    Lambda.printAllLambda(numbers);
  }

  @Test
  public void runThread() throws Exception {
    Lambda.runThread();
  }

  @Test
  public void sumAll() throws Exception {
    int actual = Lambda.sumStrategy(numbers, (integer) -> true);
    assertThat(actual)
        .as("새로 구현한 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(21);
    assertThat(actual)
        .as("as-is 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(Lambda.sumAll(numbers));
  }

  @Test
  public void sumAllEven() throws Exception {
    int actual = Lambda.sumStrategy(numbers, (integer) -> integer % 2 == 0);
    assertThat(actual)
        .as("새로 구현한 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(12);
    assertThat(actual)
        .as("as-is 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(Lambda.sumAllEven(numbers));
  }

  @Test
  public void sumAllOverThree() throws Exception {
    int actual = Lambda.sumStrategy(numbers, (integer) -> integer > 3);
    assertThat(actual)
        .as("새로 구현한 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(15);
    assertThat(actual)
        .as("as-is 메서드가 잘 동작하는지 검증한다")
        .isEqualTo(Lambda.sumAllOverThree(numbers));
  }
}
