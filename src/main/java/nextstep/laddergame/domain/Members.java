package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Members {

  private final List<Member> members;

  public Members(List<Member> members) {
    this.members = members;
  }

  public static Members createMembers(String[] userNames) {
    validate(userNames);
    return new Members(Arrays.stream(userNames)
        .map(Member::new)
        .collect(Collectors.toList()));
  }

  private static void validate(String[] userNames) {
    hasNull(userNames);
    hasDuplication(userNames);
  }

  private static void hasNull(String[] userNames) {
    long count = Arrays.stream(userNames)
        .filter(String::isEmpty)
        .count();

    if(count >= 1) {
      throw new IllegalArgumentException("ERROR : 이름에는 Null을 포함할 수 없습니다.");
    }
  }

  private static void hasDuplication(String[] userNames) {
    long count = Arrays.stream(userNames)
        .distinct()
        .count();

    if(count != userNames.length) {
      throw new IllegalArgumentException("ERROR : 이름을 중복해서 넣을 수 없습니다.");
    }
  }

  public int size() {
    return members.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    members.stream()
        .map(Member::toString)
        .forEach(sb::append);

    return sb.toString();
  }
}
