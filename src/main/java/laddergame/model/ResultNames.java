package laddergame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultNames {

  private final List<ResultName> names;

  public ResultNames(List<ResultName> names) {
    this.names = names;
  }

  public static ResultNames createByNamesWithLength(String[] names, int length) {
    if (names.length != length) {
      throw new IllegalArgumentException("입력 값의 길이가 지정된 길이와 다릅니다.");
    }

    return new ResultNames(Stream.of(names)
        .map(ResultName::createBy)
        .collect(Collectors.toList()));
  }

  public ResultName getNameByIndex(int index) {
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
    ResultNames names1 = (ResultNames) o;
    return names.equals(names1.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(names);
  }

  @Override
  public String toString() {
    return names.stream()
        .map(ResultName::toString)
        .reduce("", String::concat);
  }
}
