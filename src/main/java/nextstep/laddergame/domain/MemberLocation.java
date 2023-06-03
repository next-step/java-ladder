package nextstep.laddergame.domain;

public class MemberLocation {

  private Member member;
  private int location;

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
      return new MemberLocation(member, location - 1);
    } else if (point.checkRightWay()) {
      return new MemberLocation(member, location + 1);
    }

    return this;
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
