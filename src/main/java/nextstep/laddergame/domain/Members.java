package nextstep.laddergame.domain;

import java.util.List;

public class Members {

  private List<Member> members;

  public Members(List<Member> members) {
    this.members = members;
  }

  public boolean equalsSize(int size) {
    return this.members.size() == size;
  }
}
