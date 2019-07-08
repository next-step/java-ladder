package ladder.impl;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Targets {

  private static final String TARGETS_JOINING_SYMBOL = "";
  private static final String TARGETS_DELIMITER = ",";
  private static final int PRINT_NAME_LENGTH = 6;
  private static final String BLANK_SYMBOL = " ";

  List<String> targets;

  public Targets(List<String> parseTargets) {
    this.targets = parseTargets;
  }

  public static Targets of(String inputTargets) {
    if (isBlank(inputTargets)) {
      throw new IllegalArgumentException("결과값이 빈값일수 없습니다.");
    }
    return new Targets(parseTargets(inputTargets));
  }

  private static boolean isBlank(String inputName) {
    return inputName == null || "".equals(inputName.trim());
  }

  private static List<String> parseTargets(String inputTargets) {
    return Arrays.stream(inputTargets.split(TARGETS_DELIMITER))
        .collect(toList());
  }

  public List<String> targets() {
    return Collections.unmodifiableList(targets);
  }

  private String makeFormatLength(String target) {
    int diff = PRINT_NAME_LENGTH - target.length();
    for (int i = 0; i < diff; i++) {
      target += BLANK_SYMBOL;
    }
    return target;
  }

  public String getTarget(int targetPosition) {
    return targets.get(targetPosition);
  }

  @Override
  public String toString() {
    return targets.stream()
        .map(target -> makeFormatLength(target))
        .collect(joining(TARGETS_JOINING_SYMBOL));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Targets targets1 = (Targets) o;
    return Objects.equals(targets, targets1.targets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targets);
  }
}
