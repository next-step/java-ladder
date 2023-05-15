package nextstep.laddergame.factory;

import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;

public class MembersFactory {

  private MembersFactory() {
  }

  public static Members createMembers(String[] names) {
    List<Member> members = new ArrayList<>();
    for (String name : names) {
      members.add(new Member(name));
    }
    return new Members(members);
  }

}
