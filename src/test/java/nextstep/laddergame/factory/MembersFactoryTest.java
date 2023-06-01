package nextstep.laddergame.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.laddergame.domain.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MembersFactoryTest {

  @DisplayName("입력받은 name수 만큼 Member를 생성한다.")
  @Test
  public void createMembers() {
    String[] names = {"1", "2", "3", "4", "5"};
    Members members = MembersFactory.createMembers(names);

    assertThat(members.getSize()).isEqualTo(names.length);
  }

  @DisplayName("기존에 존재하는 이름을 갖는 참여자는 가질 수 없다.")
  @Test
  public void createMembers_throwException_ifDuplicatedName() {
    String[] names = {"1", "1", "2", "3", "4"};

    assertThatThrownBy(() -> MembersFactory.createMembers(names))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
