package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.laddergame.factory.MembersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MembersTest {

  @DisplayName("참여자들의 시작하는 위치를 반환한다.")
  @Test
  public void createStartLocation() {
    Members members = MembersFactory.createMembers(new String[]{"aaa", "bbb", "ccc"});

    List<MemberLocation> memberLocations = members.createStartLocation().getMemberLocations();
    assertThat(memberLocations.size()).isEqualTo(members.getSize());
  }
}
