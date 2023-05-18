package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

  private List<Row> rows;

  public Ladder(List<Row> rows) {
    if (rows.size() < 1) {
      throw new IllegalArgumentException("사다리의 높이(Row의 갯수)는 1보다 작을 수 없습니다.");
    }

    this.rows = rows;
  }

  public List<Row> getRows() {
    return Collections.unmodifiableList(rows);
  }
}
