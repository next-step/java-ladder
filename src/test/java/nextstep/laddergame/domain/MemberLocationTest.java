package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberLocationTest {

  private final int location = 5;

  @DisplayName("위치는 0보다 작을 수 없다.")
  @Test
  public void memberLocation_throwException_ifLocationLessThan0() {
    Member member = new Member("aaa");

    assertThatThrownBy(() -> new MemberLocation(member, -10))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("다음 단계로 넘어갈 때 Point 왼쪽에 길이 있다면 왼쪽으로 위치를 옮긴다.")
  @Test
  public void goNextStep_minusLocation_ifPointLeftWay() {
    Member member = new Member("aaa");
    MemberLocation memberLocation = new MemberLocation(member, location);
    Point point = new Point();
    point.createLineWithLeftPoint();

    MemberLocation nextMemberLocation = memberLocation.goNextStep(point);

    assertThat(nextMemberLocation.isEqualLocation(location - 1)).isTrue();
  }

  @DisplayName("다음 단계로 넘어갈 때 Point 오른쪽에 길이 있다면 오른쪽으로 위치를 옮긴다.")
  @Test
  public void goNextStep_plusLocation_ifPointRightWay() {
    Member member = new Member("aaa");
    MemberLocation memberLocation = new MemberLocation(member, location);
    Point point = new Point();
    point.createLineWithRightPoint();

    MemberLocation nextMemberLocation = memberLocation.goNextStep(point);

    assertThat(nextMemberLocation.isEqualLocation(location + 1)).isTrue();
  }

  @DisplayName("다음 단계로 넘어갈 때 길이 없다면 위치를 그대로 유지한다.")
  @Test
  public void goNextStep_stayLocation_ifPointNoWay() {
    Member member = new Member("aaa");
    MemberLocation memberLocation = new MemberLocation(member, location);
    Point point = new Point();

    MemberLocation nextMemberLocation = memberLocation.goNextStep(point);

    assertThat(nextMemberLocation.isEqualLocation(location)).isTrue();
  }

}
