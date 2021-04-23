package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {

  private final List<Name> members;

  public Members(List<Name> members) {
    hasDuplication(members);
    this.members = members;
  }

  public static Members createMembers(String[] memberNames) {
    return new Members(Arrays.stream(memberNames)
        .map(Name::new)
        .collect(Collectors.toList()));
  }

  private void hasDuplication(List<Name> members) {
    if(duplicationCount(members) != members.size()) {
      throw new IllegalArgumentException("ERROR : 이름을 중복해서 넣을 수 없습니다.");
    }
  }

  public int size() {
    return members.size();
  }

  private long duplicationCount(List<Name> members) {
    return members
        .stream()
        .distinct()
        .count();
  }

  public List<Name> names() {
    return this.members;
  }
}
