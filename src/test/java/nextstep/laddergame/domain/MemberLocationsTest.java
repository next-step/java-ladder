package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import nextstep.laddergame.factory.MembersFactory;
import nextstep.laddergame.factory.PrizesFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberLocationsTest {

  @DisplayName("위치에 해당하는 보상을 매핑하여 Map으로 반환한다.")
  @Test
  public void createResultMap() {
    Members members = MembersFactory.createMembers(new String[]{"aaa", "bbb", "ccc"});
    MemberLocations locations = members.createStartLocation();
    Prizes prizes = PrizesFactory
        .createPrizes(new String[]{"a보상", "b보상", "c보상"}, members.getSize());

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
    Members members = MembersFactory.createMembers(new String[]{"aaa", "bbb", "ccc"});
    MemberLocations locations = members.createStartLocation();
    Prizes prizes = PrizesFactory
        .createPrizes(new String[]{"a보상", "b보상", "c보상"}, members.getSize());
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
