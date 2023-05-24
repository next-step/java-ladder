package nextstep.laddergame.factory;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.laddergame.domain.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberFactoryTest {

  @DisplayName("입력받은 name수 만큼 Member를 생성한다.")
  @Test
  public void createMembers() {
    String[] names = {"1", "2", "3", "4", "5"};
    Members members = MembersFactory.createMembers(names);

    assertThat(members.getSize()).isEqualTo(names.length);
  }
}
