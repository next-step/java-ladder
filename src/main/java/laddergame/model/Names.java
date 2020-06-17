package laddergame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {

  private final List<Name> names;

  public Names(List<Name> names) {
    this.names = names;
  }

  public static Names createBy(String[] names) {
    return new Names(Stream.of(names)
        .map(s -> new Name(s.trim()))
        .collect(Collectors.toList()));
  }

  public static Names createByNamesWithLength(String[] names, PositiveNumber length) {
    if (names.length != length.getValue()) {
      throw new IllegalArgumentException("입력 값의 길이가 지정된 길이와 다릅니다.");
    }

    return new Names(Stream.of(names)
        .map(Name::new)
        .collect(Collectors.toList()));
  }

  public PositiveNumber getCountOfNames() {
    return new PositiveNumber(names.size());
  }

  public Name getNameByIndex(int index) {
    return names.get(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Names names1 = (Names) o;
    return names.equals(names1.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(names);
  }

  @Override
  public String toString() {
    return names.stream()
        .map(Name::toString)
        .reduce("", String::concat);
  }
}
