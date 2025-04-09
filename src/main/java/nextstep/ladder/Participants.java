package nextstep.ladder;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
  public static final int MAX_NAME_LENGTH = 5;
  private final List<String> names;

  private Participants(List<String> names) {
    validateNoDuplicates(names);
    validateParticipantCount(names.size());

    this.names = names;
  }

  private static void validateParticipantCount(int count) {
    if (count < 2) {
      throw new IllegalArgumentException("참여자는 2명 이상이어야 합니다.");
    }
  }

  private static void validateNoDuplicates(List<String> names) {
    long uniqueCount = names.stream().distinct().count();
    if (uniqueCount != names.size()) {
      throw new IllegalArgumentException("참여자 이름은 중복될 수 없습니다.");
    }
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
