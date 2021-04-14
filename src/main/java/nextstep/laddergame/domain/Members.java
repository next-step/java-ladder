package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {

  private final List<Member> members;

  public Members(List<Member> members) {
    hasDuplication(members);
    this.members = members;
  }

  public static Members createMembers(String[] memberNames) {
    return new Members(Arrays.stream(memberNames)
        .map(Member::new)
        .collect(Collectors.toList()));
  }

  private void hasDuplication(List<Member> members) {
    if(duplicationCount(members) != members.size()) {
      throw new IllegalArgumentException("ERROR : 이름을 중복해서 넣을 수 없습니다.");
    }
  }

  public int size() {
    return members.size();
  }

  private long duplicationCount(List<Member> members) {
    return members
        .stream()
        .distinct()
        .count();
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
