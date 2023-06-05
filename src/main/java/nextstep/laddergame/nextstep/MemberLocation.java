package nextstep.laddergame.nextstep;

import nextstep.laddergame.engine.Location;
import nextstep.laddergame.engine.Member;
import nextstep.laddergame.engine.Prize;
import nextstep.laddergame.engine.Prizes;
import nextstep.laddergame.engine.Row;
import nextstep.laddergame.engine.Point;

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

  public boolean isEqualLocation(int location) {
    return location == this.location;
  }
}
