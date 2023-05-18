package nextstep.laddergame.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;

public class MembersFactory {

  private MembersFactory() {
  }

  public static Members createMembers(String[] names) {
    List<Member> members = Arrays.stream(names)
        .map(name -> new Member(name))
        .collect(Collectors.toList());

    return new Members(members);
  }
}
