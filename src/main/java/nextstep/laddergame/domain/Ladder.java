package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Ladder {

  private final List<Row> rows;

  public Ladder(List<Row> rows) {
    if (rows.size() < 1) {
      throw new IllegalArgumentException("사다리의 높이(Row의 갯수)는 1보다 작을 수 없습니다.");
    }

    this.rows = rows;
  }

  public List<Row> getRows() {
    return Collections.unmodifiableList(rows);
  }

  public GameResult play(Members members, Prizes prizes) {
    Map<Member, Prize> gameResult = play(members).createGameResult(prizes);

    return new GameResult(gameResult);
  }

  private MemberLocations play(Members members) {
    MemberLocations startLocations = members.createStartLocation();

    return rows.stream()
        .reduce(startLocations, (locations, row) -> locations.goNextStep(row), (a, b) -> b);
  }
}
