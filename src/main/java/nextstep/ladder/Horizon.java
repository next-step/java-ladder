package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Horizon {

  private final List<Boolean> points;

  public Horizon(int countOfPerson) {
    points = RandomBooleans.form(countOfPerson);
  }

  public String asString() {
    return points.stream()
        .map(b -> b ? "---------" : "         ")
        .collect(Collectors.joining("|", "|", "|"));
  }

}
