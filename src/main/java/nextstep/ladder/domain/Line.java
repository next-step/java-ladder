package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

  private final List<Boolean> points;

  public Line (int width) {
    this.points = IntStream.range(0, width - 1)
        .mapToObj(i -> getRandomBoolean())
        .collect(ArrayList::new, (list, element) -> {
          if (list.isEmpty() || Boolean.FALSE.equals(list.get(list.size() - 1))) {
            list.add(element);
          } else {
            list.add(Boolean.FALSE);
          }
        }, ArrayList::addAll);
  }

  private Boolean getRandomBoolean() {
    return Math.random() < 0.5;
  }

}
