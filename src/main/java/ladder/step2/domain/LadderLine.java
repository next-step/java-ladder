package ladder.step2.domain;

import ladder.step2.domain.strategy.LadderLineStrategy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLine {
  private final List<Boolean> lines;

  private LadderLine (List<Boolean> lines) {
    this.lines = lines;
  }

  public static LadderLine of (int countOfPerson, LadderLineStrategy strategy) {
    boolean[] prev = { false };
    return IntStream.rangeClosed(0, countOfPerson)
                    .mapToObj(v -> {
                      prev[0] = strategy.createLine(prev[0]);
                      return prev[0];
                    }).collect(collectingAndThen(toList(), LadderLine::new));
  }
}
