package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.factory.MembersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {

  @DisplayName("Row는 입력받은 멤버수 만큼의 Point를 갖는다.")
  @Test
  public void row_throwException_ifNotEqualPointSizeAndMemberSize(){
    Members members = MembersFactory.createMembers(new String[]{"1","2","3"});
    List<Point> points = new ArrayList<>();

    assertThatThrownBy(()-> new Row(points, members)).isInstanceOf(IllegalArgumentException.class);
  }

}
