package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Members {

  private final List<Member> members;

  public Members(List<Member> members) {
    if (members.size() != new HashSet<>(members).size()) {
      throw new IllegalArgumentException("참여자 이름이 중복됩니다.");
    }

    this.members = members;
  }

  public int getSize() {
    return members.size();
  }

  public List<Member> getMembers() {
    return Collections.unmodifiableList(members);
  }

  public MemberLocations createStartLocation() {
    List<MemberLocation> memberLocations = IntStream.range(0, members.size())
        .mapToObj(i -> new MemberLocation(members.get(i), i))
        .collect(Collectors.toList());

    return new MemberLocations(memberLocations);
  }
}
