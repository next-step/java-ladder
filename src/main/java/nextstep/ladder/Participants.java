package nextstep.ladder;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
  private static final int MAX_NAME_LENGTH = 5;
  private final List<String> names;

  private Participants(List<String> names) {
    this.names = names;
  }

  public static Participants of(List<String> rawNames) {
    List<String> trimmed = rawNames.stream()
        .map(String::trim)
        .map(name -> name.length() > MAX_NAME_LENGTH ? name.substring(0, MAX_NAME_LENGTH) : name)
        .collect(Collectors.toList());
    return new Participants(trimmed);
  }

  public int count() {
    return names.size();
  }

  public OptionalInt indexOf(String name) {
    return IntStream.range(0, names.size())
        .filter(i -> names.get(i).equals(name))
        .findFirst();
  }

  public List<String> names() {
    return names;
  }

}
