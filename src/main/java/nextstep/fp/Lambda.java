package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lambda {

  private static final Logger log = LoggerFactory.getLogger(Lambda.class);

  public static void printAllOld(List<Integer> numbers) {
    log.info("printAllOld");

    for (int number : numbers) {
      log.info("{}", number);
    }
  }

  public static void printAllLambda(List<Integer> numbers) {
    log.info("printAllLambda");

    numbers.forEach(i -> log.info("{}", i));
  }

  public static void runThread() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        log.info("Hello from thread");
      }
    }).start();
  }

  public static int sumAll(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
      total += number;
    }
    return total;
  }

  public static int sumAllEven(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
      if (number % 2 == 0) {
        total += number;
      }
    }
    return total;
  }

  public static int sumAllOverThree(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
      if (number > 3) {
        total += number;
      }
    }
    return total;
  }

  public static int sumStrategy(List<Integer> numbers, Predicate<Integer> predicate) {
    return numbers.stream()
        .filter(predicate)
        .reduce(0, Integer::sum);
  }
}
