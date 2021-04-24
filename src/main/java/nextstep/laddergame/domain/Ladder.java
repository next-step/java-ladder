package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  public Lines lines() {
    return this.lines;
  }

  public Members members() {
    return this.members;
  }

  public int match(Name member) {
    return lines.next(candidate(member));
  }

  public List<Integer> matches(Members members) {
    return IntStream.range(0, members.size())
        .mapToObj(lines::next)
        .collect(Collectors.toList());
  }

  private int candidate(Name member) {
    return members.names()
        .indexOf(member);
  }
}
