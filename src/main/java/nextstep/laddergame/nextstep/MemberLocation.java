package nextstep.laddergame.nextstep;

import java.util.Objects;
import nextstep.laddergame.engine.Location;
import nextstep.laddergame.engine.Member;
import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.Prize;
import nextstep.laddergame.engine.Prizes;
import nextstep.laddergame.engine.Row;

public class MemberLocation implements Location {

  private final Member member;
  private final int location;

  public MemberLocation(Member member, int location) {
    if (member == null) {
      throw new IllegalArgumentException();
    }
    if (location < 0) {
      throw new IllegalArgumentException("위치는 0보다 작을 수 없습니다.");
    }

    this.member = member;
    this.location = location;
  }

  public Point getPoint(Row row) {
    return row.getPoint(location);
  }

  public MemberLocation goNextStep(Point point) {
    if (point.checkLeftWay()) {
      return goLeft();
    } else if (point.checkRightWay()) {
      return goRight();
    }

    return this;
  }

  private MemberLocation goLeft() {
    return new MemberLocation(member, location - 1);
  }

  private MemberLocation goRight() {
    return new MemberLocation(member, location + 1);
  }

  public Member getMember() {
    return member;
  }

  public Prize getPrize(Prizes prizes) {
    return prizes.getPrize(location);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberLocation that = (MemberLocation) o;
    return location == that.location && Objects.equals(member.getName(), that.member.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(member, location);
  }
}
