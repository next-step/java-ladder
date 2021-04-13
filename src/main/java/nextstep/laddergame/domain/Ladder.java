package nextstep.laddergame.domain;

public class Ladder {

  private final Members members;
  private final Lines lines;

  public Ladder(Members members, Lines lines) {
    this.members = members;
    this.lines = lines;
  }

  public static Ladder createLadder(int height, Members members) {
    return new Ladder(members,
        Lines.createLines(height, members.size() - 1));
  }

  @Override
  public String toString() {
    return members.toString() + "\n"
        + lines.toString();
  }
}
