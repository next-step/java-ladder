package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {

  private List<String> vline;
  private List<String> hline;

  @BeforeEach
  void setUp() {
    vline = Arrays.asList("|", "|", "|", "|", "|");
    hline = Arrays.asList("-", "-", "-", "-", "-");
  }

  @Test
  void vertical5OneLine() {
    vline.stream()
        .forEach(System.out::println);
  }

  @Test
  void horizontal5OneLine() {
    hline.stream()
        .forEach(System.out::print);
  }

  @Test
  void rectangle() {
    List<List<String>> square = Arrays.asList(
        Arrays.asList("|", "---------", "|"),
        Arrays.asList("|", "         ", "|"),
        Arrays.asList("|", "         ", "|"),
        Arrays.asList("|", "         ", "|"),
        Arrays.asList("|", "         ", "|"),
        Arrays.asList("|", "---------", "|")
    );
    for (List<String> x : square) {
      for (String p : x) {
        System.out.print(p);
      }
      System.out.print("\n");
    }
  }

  @Test
  void rectangleWithHorizon() {
    List<Horizon> square = Arrays.asList(
        Horizon.of(Arrays.asList("|", "---------", "|")),
        Horizon.of(Arrays.asList("|", "         ", "|")),
        Horizon.of(Arrays.asList("|", "         ", "|")),
        Horizon.of(Arrays.asList("|", "         ", "|")),
        Horizon.of(Arrays.asList("|", "         ", "|")),
        Horizon.of(Arrays.asList("|", "---------", "|"))
    );
    for (Horizon x : square) {
      for (String point : x.getPoints()) {
        System.out.print(point);
      }
      System.out.print("\n");
    }
  }

  @Test
  void oneHorizonByCount() {
    Horizon horizon = new Horizon(3);
    for (String point : horizon.getPoints()) {
      System.out.print(point);
    }
  }
}
