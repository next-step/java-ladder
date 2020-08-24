package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Horizon {

  private static final String AIR = "        ";
  private static final String BRIDGE = "--------";
  private static final String PIER = "|";

  private final List<Boolean> points;

  public Horizon(int countOfPerson) {
    points = HorizonGenerator.form(countOfPerson);
  }

  public String render(boolean hasBridge) {
    return hasBridge ? BRIDGE : AIR;
  }

  @Override
  public String toString() {
    return points.stream()
        .map(this::render)
        .collect(Collectors.joining(PIER, PIER, PIER));
  }
}
