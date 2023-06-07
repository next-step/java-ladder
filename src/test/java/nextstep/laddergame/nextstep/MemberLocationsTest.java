package nextstep.laddergame.nextstep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import nextstep.laddergame.engine.Member;
import nextstep.laddergame.engine.Members;
import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.Prize;
import nextstep.laddergame.engine.Prizes;
import nextstep.laddergame.engine.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberLocationsTest {

  @DisplayName("참여자들의 시작하는 위치정보를 반환한다.")
  @Test
  public void createStartLocation() {
    Members members = new Members(new String[]{"aaa", "bbb", "ccc"});

    MemberLocations memberLocations = MemberLocations.createStartLocation(members);
  }

  @DisplayName("위치에 해당하는 보상을 매핑하여 Map으로 반환한다.")
  @Test
  public void createResultMap() {
    Members members = new Members(new String[]{"aaa", "bbb", "ccc"});
    MemberLocations locations = MemberLocations.createStartLocation(members);
    Prizes prizes = new Prizes(new String[]{"a보상", "b보상", "c보상"}, members.getSize());

    Map<Member, Prize> resultMap = locations.createGameResult(prizes);

    assertAll(
        () -> assertThat(resultMap.get(new Member("aaa"))).isEqualTo(new Prize("a보상")),
        () -> assertThat(resultMap.get(new Member("bbb"))).isEqualTo(new Prize("b보상")),
        () -> assertThat(resultMap.get(new Member("ccc"))).isEqualTo(new Prize("c보상"))
    );
  }

  @DisplayName("다음 단계로 이동 후 위치에 해당하는 보상을 매핑하여 Map으로 반환한다.")
  @Test
  public void createResultMap_NextStep() {
    Members members = new Members(new String[]{"aaa", "bbb", "ccc"});
    MemberLocations locations = MemberLocations.createStartLocation(members);
    Prizes prizes = new Prizes(new String[]{"a보상", "b보상", "c보상"}, members.getSize());
    Point aPoint = new Point();
    aPoint.createLineWithRightPoint();
    Point bPoint = new Point();
    bPoint.createLineWithLeftPoint();
    Point cPoint = new Point();
    locations = locations.goNextStep(new Row(List.of(aPoint, bPoint, cPoint)));

    Map<Member, Prize> resultMap = locations.createGameResult(prizes);

    assertAll(
        () -> assertThat(resultMap.get(new Member("aaa"))).isEqualTo(new Prize("b보상")),
        () -> assertThat(resultMap.get(new Member("bbb"))).isEqualTo(new Prize("a보상")),
        () -> assertThat(resultMap.get(new Member("ccc"))).isEqualTo(new Prize("c보상"))
    );
  }
}
