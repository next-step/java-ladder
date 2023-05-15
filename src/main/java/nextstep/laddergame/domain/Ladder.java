package nextstep.laddergame.domain;

import java.util.List;

public class Ladder {

  private List<Row> rows;

  public Ladder(List<Row> rows, Height height) {
    if (!height.equals(rows.size())) {
      throw new IllegalArgumentException("사다리는 입력받은 높이만큼 Row(행)를 가져야합니다.");
    }

    this.rows = rows;
  }
}
