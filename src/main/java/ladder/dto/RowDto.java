package ladder.dto;

import ladder.domain.Row;

import java.util.List;

public class RowDto {
  private final List<Boolean> values;

  public RowDto(Row row) {
    this.values = row.values();
  }

  public List<Boolean> getValues() {
    return this.values;
  }
}
