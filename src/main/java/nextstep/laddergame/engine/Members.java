package nextstep.laddergame.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Members {

  private final List<Member> members;

  public Members(List<Member> members) {
    validateMembers(members);

    this.members = members;
  }

  public Members(String[] names) {
    List<Member> members = Arrays.stream(names)
        .map(name -> new Member(name))
        .collect(Collectors.toList());

    validateMembers(members);

    this.members = members;
  }

  private void validateMembers(List<Member> members) {
    if (members.size() != new HashSet<>(members).size()) {
      throw new IllegalArgumentException("참여자 이름이 중복됩니다.");
    }
  }

  public int getSize() {
    return members.size();
  }

  public Member getMember(int location) {
    return members.get(location);
  }

  public List<Member> getMembers() {
    return Collections.unmodifiableList(members);
  }
}
