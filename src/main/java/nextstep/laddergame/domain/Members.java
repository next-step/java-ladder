package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Members {

  private List<Member> members;

  public Members(List<Member> members) {
    this.members = members;
  }

  public int getSize() {
    return members.size();
  }

  public List<Member> getMembers() {
    return Collections.unmodifiableList(members);
  }
}
