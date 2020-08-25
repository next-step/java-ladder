package nextstep.ladder.study;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineRenderingTest {

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

}
